package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t")
public class ControllerTest3 {

    @RequestMapping("/test3")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest3");

        return "test";
    }
}
