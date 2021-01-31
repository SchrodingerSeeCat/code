package com.valid.boot.controller;

import com.valid.boot.bean.Car;
import com.valid.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot! 你好";
    }

//    @Autowired
//    private Car car;
//
//    @RequestMapping("/car")
//    public String car() {
//        return car.toString();
//    }

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public String person() {
        return person.toString();
    }
}
