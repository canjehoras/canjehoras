package com.vcortes.canjehoras.utils;


import java.util.Properties;

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

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Clase que gestiona el envio de emails
 * 
 * @author Vanesa Cortés
 *
 */
public class Mail {

	private static Logger log = Logger.getLogger(Mail.class);

	/**
	 * Método que envia un email
	 * 
	 * @param mailTo email receptor
	 * @param from email emisor
	 * @param cc email copia
	 * @param asunto
	 * @param texto
	 * @param nombreFichero
	 * @param adjunto
	 * @return true si se ha enviado, false si no se ha enviado
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
			bodyPart.setContent(texto, mailContentType);
			
			multiPart.addBodyPart(bodyPart);

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
	 * Clase MailAuthenticator
	 * 
	 * @author Vanesa Cortés
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
