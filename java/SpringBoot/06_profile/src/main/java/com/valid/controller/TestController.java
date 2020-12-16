package com.valid.controller;

import com.valid.model.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    AcmeProperties acme;

    @RequestMapping("acme")
    public AcmeProperties acme() {
        return acme;
    }
}
