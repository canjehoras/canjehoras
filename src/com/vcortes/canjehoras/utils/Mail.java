package es.pwc.riesgos.utils;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.imageio.ImageIO;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.apache.axis.attachments.OctetStream;
import org.apache.axis.attachments.OctetStreamDataSource;
import org.apache.axis.encoding.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import es.pwc.riesgos.bl.RMailsBL;
import es.pwc.riesgos.commons.BeanGetter;
import es.pwc.riesgos.commons.M;
import es.pwc.riesgos.model.RMails;

/**
 * Clase que tiene las funciones principales para el envio de e-mails
 */
public class Mail {

	private static Logger log = Logger.getLogger(Mail.class);

	/**
	 * Metodo que envia un email directamente
	 * 
	 * @param mail Direccion destino del e-mail
	 * @param cc Resto de direcciones de destino
	 * @param asunto Asunto del e-mail
	 * @param texto Cuerpo del mensaje
	 * @param nombreFichero Nombre del fichero a adjuntar
	 * @param adjunto Fichero a adjuntar
	 * @return true si el mensaje ha sido enviado, false en caso contrario
	 */
	public Boolean enviarMail(String mailTo, String from, String[] cc, String asunto, String texto, String nombreFichero, byte[] adjunto) {
		log.debug("[MAIL] ENVIANDO MAIL....");
		Boolean error = false;
		String smtpHost = M.sg("servidor.mail.smtp.url");
		String smtpTtls = M.sg("servidor.mail.smtp.ttls");
		String smtpPort = M.sg("servidor.mail.smtp.puerto");
		String authUser = M.sg("servidor.mail.smtp.user");
		String authPass = M.sg("servidor.mail.smtp.pass");
		String authFrom = M.sg("servidor.mail.from");
		String mailContentType = M.sg("servidor.mail.content_type"); 
	
		try {
			Properties props = System.getProperties();
	
			// Define el servidor de correo
			props.put("mail.smtp.host", smtpHost);
			// TLS si esta disponible
			if (!StringUtils.isEmpty(smtpTtls)){
				props.setProperty("mail.smtp.starttls.enable", smtpTtls);
			}
	
			// Puerto de para envio de correos si no esta vacio
			if (!StringUtils.isEmpty(smtpPort)){
				props.setProperty("mail.smtp.port", smtpPort);
			}
	
			// Obtiene la sesionn
			Session session = null;
			if (authUser != null && !authUser.trim().equals("")){
				session = Session.getInstance(props,new MailAuthenticator(authUser,authPass));
			} else {
				session = Session.getInstance(props);
			}
			
			// Definimos el message
			Message message = new MimeMessage(session);
			InternetAddress adrTo = new InternetAddress(mailTo);
			message.addRecipient(Message.RecipientType.TO, adrTo);
	
			//Por si el mensaje tiene varios destinatarios en copia
			if (null != cc && cc.length != 0) {
				Address[] adrCC = new Address[cc.length];
				for (int i = 0; i < cc.length; i++) {
					adrCC[i] = new InternetAddress(cc[i]);
				}
				message.addRecipients(Message.RecipientType.CC, adrCC);
			}
			
			//Definimos el cuerpo del mensaje
			BodyPart bodyPart = new MimeBodyPart();
			MimeMultipart multiPart = new MimeMultipart();
			
			if(texto.toUpperCase().contains("@@FIRMA")){
				multiPart.addBodyPart(createInlineImagePart());
				texto = reemplazar(texto);
			}
			
			bodyPart.setContent(texto, mailContentType);
			
			multiPart.addBodyPart(bodyPart);
		
			
			//INCLUIMOS EL contenido
			//Por si en algun momento queremos enviar adjuntos (habria que revisarlo)
			if (adjunto != null && adjunto.length > 0 && !StringUtils.isEmpty(nombreFichero)) {
				// Create the message part
				BodyPart messageBody2 = new MimeBodyPart();
				DataSource source = new OctetStreamDataSource("adjunto",new OctetStream(adjunto));
				messageBody2.setDataHandler(new DataHandler(source));
				messageBody2.setFileName(nombreFichero);
				multiPart.addBodyPart(messageBody2);
			} 
			
			//Anadimos al mensaje el cuerpo y el asunto
	        message.setContent(multiPart, mailContentType);
	        if(asunto!=null){
	        	//En el asunto no puede haber saltos de linea, por los que los quitamos
	        	message.setSubject(asunto.replace("\n", " "));
	        }

	        // Si en el properties hay un from lo cogemos de ahí, sino de bbdd
	        if(authFrom!=null && !authFrom.equals("")){
		        // From de properties
		        message.setFrom(new InternetAddress(authFrom));
	        }else{
		        // From de base de datos
		        message.setFrom(new InternetAddress(from));
	        }
	
			// EMVIAMOS EL MENSAJE
			Transport t = session.getTransport("smtp");
			if (authUser != null && !authUser.trim().equals("")){
				t.connect(authUser, authPass);
			} else {
				t.connect();
			}
            t.sendMessage(message, message.getAllRecipients());
            // Cerramos conexion transport
            t.close();
            
			log.debug("[MAIL] MAIL ENVIADO CORRECTAMENTE");
	
		} catch (AddressException e) {
			log.error("Error al enviar el e-mail - AddressException - ", e);
			error = true;
		} catch (MessagingException e) {
			log.error("Error al enviar el e-mail - MessagingException - ", e);
			error = true;
		} catch (Exception e) {
			log.error("Error al enviar el e-mail - Exception - ", e);
			error = true;
		}
		return error;
	}
	
	/**
	 * Método que comprueba el número de veces que aparece la firma, ya que en los mails agrupados aparece más de una vez.
	 * Si aparece más de una vez se quita y se pone al final.
	 * @param texto
	 * @return
	 */
	private String reemplazar(String texto){
		int count = StringUtils.countMatches(texto, "@@FIRMA");
		if(count>1){
			texto = texto.replace("@@FIRMA", "");
			texto = texto + ("<BR>"+ "<img src=\"cid:firma\"/>");
		} else {
			texto = texto.replace("@@FIRMA", "<img src=\"cid:firma\"/>");
		}
		return texto;
	}
	
	
	/**
	 * Método que recupera una imagen y la inserta en el email como una parte más del body
	 * 
	 * @return
	 */
	private BodyPart createInlineImagePart()  {

        MimeBodyPart imagePart =null;
        try{
        	ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		    HttpServletRequest request = sra.getRequest();    
		    
		    
        	imagePart = new MimeBodyPart();
        	String urlString =  request.getRequestURL().toString().substring(0, request.getRequestURL().toString().lastIndexOf("/")) 
        			+ "/" + M.sg("nombre.carpeta.archivos.raiz") + "/";
        	URL url = new URL (urlString + M.sg("nombre.imagen.firma"));
			BufferedImage img = ImageIO.read(url);
		    ByteArrayOutputStream os = new ByteArrayOutputStream();
		    ImageIO.write(img, "jpg", os);
            os.flush();
        	
			DataSource source = new OctetStreamDataSource("firma",new OctetStream(os.toByteArray()));
			imagePart.setDataHandler(new DataHandler(source));
			imagePart.setFileName("firma.jpg");
			imagePart.setContentID("<firma>");
			
        }
        catch(Exception exp)
        {
            log.error("17 - Logo Attach Error : "+exp);
        }

        return imagePart;
	}

	
	
	/**
	 * NO SE UTILIZA PERO SE DEJA 
	 * Pasamos al texto el filtro para sustiuir parámetros (campos marcados con @@)
	 * @param texto
	 */
	private String filtroParametros(String texto){
		log.debug("filtroParametros :: Mail");
		try {
			URL url = new URL("http://10.12.8.27:8684/grcsuite/images/" + M.sg("nombre.imagen.firma"));
			BufferedImage img = ImageIO.read(url);
		    //img = ImageIO.read(new File(M.sg("nombre.imagen.firma")));
		    
		    ByteArrayOutputStream os = new ByteArrayOutputStream();
		    ImageIO.write(img, "jpg", os);
		    InputStream is = new ByteArrayInputStream(os.toByteArray());
		    
		    byte [] data = os.toByteArray();
		    Base64.encode(data);
			// codificamos la imagen a base64
			String imgBase64 = Base64.encode(data);
			
			return imgBase64;
		} catch (Exception e) {
			log.error("Error obteniendo imagen",e);
		}
		
		
		return "";		
	}
	
	
	/**
	 * Metodo que obtiene de la tabla R_MAILS los email que no han sido enviados (ENVIADO = 0), los recorre uno a uno y los envia. 
	 * Si el envio ha sido satisfactorio, los marca como enviados
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	public boolean enviarMail() throws Exception {
		Boolean errorTotal = false;
		try {
			RMailsBL rMailsBL = (RMailsBL) BeanGetter.getBean("RMailsBL");
			List<RMails> l = rMailsBL.getMailsNoEnviadosSinCC();
			List<RMails> l2 = rMailsBL.getMailsNoEnviadosConCC();
			if (l!=null && l.size()>0) {
				BigDecimal tpProceso = null;
				List<RMails> lNormativa = null;
				for (RMails mail:l) {
					if (tpProceso == null) {
						tpProceso = mail.getFkTpProcesoRiesgos();
						lNormativa = new ArrayList<RMails>(); 
						lNormativa.add(mail);
					} else if (tpProceso.compareTo(mail.getFkTpProcesoRiesgos()) == 0) {
						lNormativa.add(mail);
					} else {
						if (rMailsBL.normativaMailsAgrupados(tpProceso)) {
							errorTotal &= enviarMailNormativaAgrupado(lNormativa);
						} else {
							errorTotal &= enviarMailNormativa(lNormativa);
						}
						tpProceso = mail.getFkTpProcesoRiesgos();
						lNormativa = new ArrayList<RMails>(); 
						lNormativa.add(mail);
					}
				}
				//ultima normativa
				if (rMailsBL.normativaMailsAgrupados(tpProceso)) {
					errorTotal &= enviarMailNormativaAgrupado(lNormativa);
				} else {
					errorTotal &= enviarMailNormativa(lNormativa);
				}
			} else {
				if (!(l2!=null && l2.size()>0)) {
					errorTotal = true;
				}
			}
			if (l2!=null && l2.size()>0) {
				errorTotal &= enviarMailNormativa(l2);
			}
		} catch (Exception e) {
			errorTotal = true;
			e.printStackTrace();
		}
		
		return errorTotal;
		
	}
	
	public boolean enviarMailNormativa(List<RMails> l) throws Exception {
		Boolean error = false;
		Boolean errorTotal = false;
		try{
			RMailsBL rMailsBL = (RMailsBL) BeanGetter.getBean("RMailsBL");
			if (l!=null && l.size()>0) {
				List<RMails> ids = new ArrayList<RMails>(); 
				for (RMails mail:l) {
					mail.setEnviado(true);
					ids = new ArrayList<RMails>();
					ids.add(mail);
					Mail m = new Mail();
					String[] cc = mail.getUsrCc()!=null?mail.getUsrCc().split(","):null;
					String subject = mail.getMailSubject()!=null?mail.getMailSubject():"";
					String body = mail.getMailBody()!=null?mail.getMailBody():"";
					error = m.enviarMail(mail.getUsrTo(), mail.getUsrFrom(), cc, subject, body, null, null);
					errorTotal = error && errorTotal;
					if (!error){
						rMailsBL.setEnviados(ids);
					}
				}
			}
		}catch (Exception e) {
			errorTotal = true;
			e.printStackTrace();
		}
		
		return errorTotal;
		
	}
	
	public boolean enviarMailNormativaAgrupado(List<RMails> l) throws Exception {
		Boolean error = false;
		Boolean errorTotal = false;
		try{
			RMailsBL rMailsBL = (RMailsBL) BeanGetter.getBean("RMailsBL");
			if (l!=null && l.size()>0) {
				StringBuffer asunto = new StringBuffer();
				StringBuffer cuerpo = new StringBuffer();
				String usuarioAnterior = "";
				Integer tipoMailAnterior = 0;
				String fromAnterior = "";
				List<RMails> ids = new ArrayList<RMails>(); 
				for (RMails mail:l) {
					if (!usuarioAnterior.equals(mail.getUsrTo()) || mail.getTipoMail().compareTo(tipoMailAnterior) != 0) {
						if (!usuarioAnterior.equals("")){
							Mail m = new Mail();
							error = m.enviarMail(usuarioAnterior, fromAnterior, null, asunto.toString(), cuerpo.toString(), null, null);
							errorTotal = error && errorTotal;
							if (!error){
								rMailsBL.setEnviados(ids);
							}
						}
						asunto = new StringBuffer(mail.getMailSubject()!=null?mail.getMailSubject():"");
						cuerpo = new StringBuffer(mail.getMailBody()!=null?mail.getMailBody():"");
						usuarioAnterior = mail.getUsrTo();
						tipoMailAnterior = mail.getTipoMail();
						fromAnterior = mail.getUsrFrom();
						ids = new ArrayList<RMails>();
						mail.setEnviado(true);
						ids.add(mail);
					} else {
						asunto = new StringBuffer(mail.getMailSubject()!=null?mail.getMailSubject():"");
						cuerpo.append("<BR>"+(mail.getMailBody()!=null?mail.getMailBody():""));
						mail.setEnviado(true);
						ids.add(mail);
					}
				}
				if (!usuarioAnterior.equals("")){
					//enviar el último mail
					Mail m = new Mail();
					error = m.enviarMail(usuarioAnterior, fromAnterior, null, asunto.toString(), cuerpo.toString(), null, null);
					errorTotal = error && errorTotal;
					if (!error){
						rMailsBL.setEnviados(ids);
					}
				}
			}
		}catch (Exception e) {
			errorTotal = true;
			e.printStackTrace();
		}
		
		return errorTotal;
		
	}

	/**
	 * Clase MailAuthenticator
	 * @author emarin
	 *
	 */
	class MailAuthenticator extends Authenticator {
	    String user;
	    String pw;
	    public MailAuthenticator (String username, String password)
	    {
	       super();
	       this.user = username;
	       this.pw = password;
	    }
	   public PasswordAuthentication getPasswordAuthentication()
	   {
	      return new PasswordAuthentication(user, pw);
	   }
	}

}
