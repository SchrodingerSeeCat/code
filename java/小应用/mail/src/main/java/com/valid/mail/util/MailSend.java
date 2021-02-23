package com.valid.mail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailSend {
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void emailSend(String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("471068961@qq.com");
        message.setTo("471068961@qq.com");
        message.setSubject("邮件主题");
        message.setText(text);
        javaMailSender.send(message);
    }
}
