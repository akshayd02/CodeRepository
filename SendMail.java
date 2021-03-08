package com.ae.main;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {

  public static void main(String[] args) throws Exception{
       
       
       String from = "trialbot@automationedge.com";
       String login = "trialbot@automationedge.com";
       String password = "Automationbot@123";
  
        Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "smtp.office365.com");
        mailProps.put("mail.smtp.host", "m.outlook.com");
        mailProps.put("mail.smtp.port", "587");
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.socketFactory.port", "587");
        mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
        mailProps.put("mail.smtp.socketFactory.fallback", "false");
        mailProps.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getDefaultInstance(mailProps, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication("trialbot@automationedge.com", "Automationbot@123");
            }

        });

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        String[] emails = {"akshay.dorle@vyomlabs.com"};
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
