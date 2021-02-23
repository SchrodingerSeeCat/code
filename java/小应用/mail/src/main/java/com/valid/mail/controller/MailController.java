package com.valid.mail.controller;

import com.valid.mail.util.MailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailSend mailSend;


    @GetMapping("/")
    public String email() {
        mailSend.emailSend("测试");
        System.out.println("成功");
        return "成功";
    }
}
