package com.valid.controller;

import com.valid.model.Person;
import com.valid.model.ValueProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 属性校验
    @Autowired
    Person person;

    @RequestMapping("yaml")
    public Person yaml() {
        return person;
    }

    // @Value
    @Autowired
    ValueProperties valueProperties;

    @RequestMapping("value")
    public ValueProperties value() {
        return valueProperties;
    }
}
