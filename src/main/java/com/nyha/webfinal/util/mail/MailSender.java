package com.nyha.webfinal.util.mail;

import com.nyha.webfinal.exception.ProjectException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailSender {
    private MimeMessage message;
    private final String sendToEmail;
    private final String mailSubject;
    private final String mailText;
    private final Properties properties;
    private static final String PROPERTY_NAME = "mail.properties";

    public MailSender(String sendToEmail, String mailSubject, String mailText) throws ProjectException {
        try {
            this.sendToEmail = sendToEmail;
            this.mailSubject = mailSubject;
            this.mailText = mailText;
            properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream(PROPERTY_NAME);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ProjectException(e);
        }
    }

    public void send() throws ProjectException {
        try {
            initMessage();
            Transport.send(message);
        } catch (MessagingException e) {
            throw new ProjectException(e);
        }
    }

    private void initMessage() throws MessagingException {
        Session mailSession = MailSessionFactory.createSession(properties);
        mailSession.setDebug(true);
        message = new MimeMessage(mailSession);
        message.setSubject(mailSubject);
        message.setContent(mailText, "text/html");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
    }
}
