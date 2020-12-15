package com.valid.sboot.controller;

import com.valid.sboot.model.YamlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlController {

    @Autowired
    private YamlModel yamlModel;

    @RequestMapping("yaml")
    public String hello() {
        return  yamlModel.toString();
    }
}
