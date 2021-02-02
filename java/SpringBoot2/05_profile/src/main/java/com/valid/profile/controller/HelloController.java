package com.valid.profile.controller;

import com.valid.profile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name:默认值}")
    private String name;

    @Autowired
    private Person person;

    @Value("${MAVEN_HOME}")
    private String msg;

    @GetMapping("/")
    public String name() {
        return name;
    }

    @GetMapping("/person")
    public String person() {
        return person.toString();
    }

    @GetMapping("/msg")
    public String msg() {
        return msg;
    }

}
