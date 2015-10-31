package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Анна on 31.10.2015.
 */
public class MailSender {

    private String recipients;
    private StringBuilder result;

    public MailSender(String recipients, StringBuilder result) {
        this.recipients = recipients;
        this.result = result;
    }

    public void send() throws MessagingException {
        // now when the report is built we need to send it to the recipients list
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();


        // we're going to use google mail to send this message
        mailSender.setHost("mail.google.com");


        // construct the message
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);


        // setting message text, last parameter 'true' says that it is HTML format
        helper.setText(result.toString(), true);
        helper.setSubject("Monthly department salary report");


        // send the message
        mailSender.send(message);

    }
}