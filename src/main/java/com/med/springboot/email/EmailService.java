package com.med.springboot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendThankYouEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mousmohamed719@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Thank You for Contacting Me!");
        message.setText(
                "As-salamu alaykum " + name + ",\n\n" +
                        "Thank you very much for reaching out! I've received your message " +
                        "and truly appreciate you taking the time to contact me.\n\n" +
                        "I'll get back to you as soon as possible.\n\n" +
                        "Best regards,\n" +
                        "Mous Mohammed\n" +
                        "Full-Stack Developer"
        );

        mailSender.send(message);
    }
}