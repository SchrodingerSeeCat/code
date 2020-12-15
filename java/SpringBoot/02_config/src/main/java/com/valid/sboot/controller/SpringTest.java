package com.valid.sboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTest {

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }
}
