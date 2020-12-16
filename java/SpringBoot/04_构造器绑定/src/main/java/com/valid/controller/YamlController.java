package com.valid.controller;

import com.valid.model.AcmeProperties;
import com.valid.model.AnotherComponent;
import com.valid.model.OwnerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(AcmeProperties.class)
public class YamlController {

    @Autowired
    private AcmeProperties acme;

    @Autowired
    private AnotherComponent anotherComponent;

    @RequestMapping("test")
    public AcmeProperties test() {
        return acme;
    }

    @RequestMapping("/another")
    public AnotherComponent another() {
        return anotherComponent;
    }

    @Autowired
    private OwnerProperties ownerProperties;

    @RequestMapping("owner")
    public OwnerProperties owner() {
        return ownerProperties;
    }
}
