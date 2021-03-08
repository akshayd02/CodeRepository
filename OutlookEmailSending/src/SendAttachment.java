import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachment {
	public static void main(String[] args) throws Exception {
		String from = "akshaydorle_13459@aitpune.edu.in";
		String login = "akshaydorle_13459@aitpune.edu.in";
		String password = "2869worldS*";

		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.host", "smtp.office365.com");
		mailProps.put("mail.smtp.port", "587");
		mailProps.put("mail.smtp.auth", "true");
		/*
		 * mailProps.put("mail.smtp.socketFactory.port", "587");
		 * mailProps.put("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * mailProps.put("mail.smtp.socketFactory.fallback", "true");
		 */
		mailProps.put("mail.smtp.starttls.enable", "true");

		Session mailSession = Session.getDefaultInstance(mailProps, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, password);
			}

		});

		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		String[] emails = { "akshay.dorle@vyomlabs.com" };
		InternetAddress dests[] = new InternetAddress[emails.length];
		for (int i = 0; i < emails.length; i++) {
			dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
		}
		message.setRecipients(Message.RecipientType.TO, dests);
		message.setSubject("Test", "UTF-8");
		Multipart mp = new MimeMultipart();
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setContent("This is test mail.", "text/html;charset=utf-8");
		mp.addBodyPart(mbp);
		message.setContent(mp);
		message.setSentDate(new java.util.Date());

		Transport.send(message);
	}

}
