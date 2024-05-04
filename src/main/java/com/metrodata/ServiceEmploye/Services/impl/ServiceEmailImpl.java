package com.metrodata.ServiceEmploye.Services.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;
import com.metrodata.ServiceEmploye.Models.dto.Request.EmailRequest;
import com.metrodata.ServiceEmploye.Services.EmailServices;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceEmailImpl implements EmailServices {
    private JavaMailSender mailSender;

    @Override
    public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        mailSender.send(message);
        return emailRequest;
    }

    @SuppressWarnings("null")
    @Override
    public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttachment()));

            helper.addAttachment(file.getFilename(), file);
            log.info(
                    "Successfully send email by attachment to {}",
                    emailRequest.getTo());
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("Failed send email by attachment to {}", emailRequest.getTo());
            System.out.println("Error = " + e.getMessage());
        }

        return emailRequest;
    }
}