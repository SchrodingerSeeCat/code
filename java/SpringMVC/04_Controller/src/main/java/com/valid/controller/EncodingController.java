package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {
    @PostMapping("/encoding")
    public String test(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }

    @GetMapping("/encoding")
    public String test1(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }
}
