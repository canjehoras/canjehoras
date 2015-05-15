package com.vcortes.canjehoras.utils;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


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
			
			bodyPart.setDataHandler(new DataHandler(new FileDataSource("../img/sinfoto.jpg")));
			bodyPart.setContent(texto, mailContentType);
			
			multiPart.addBodyPart(bodyPart);
		
			
			//INCLUIMOS EL contenido
			//Por si en algun momento queremos enviar adjuntos (habria que revisarlo)
			if (adjunto != null && adjunto.length > 0 && !StringUtils.isEmpty(nombreFichero)) {
				// Create the message part
				BodyPart messageBody2 = new MimeBodyPart();
				DataSource source = new OctetStreamDataSource("adjunto", new OctetStream(adjunto));
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
