package com.valid.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/thymeleaf")
    public String Thymeleaf(Model model) {

        // Model 中的放入的数据会自动放入到请求域中‘
        model.addAttribute("test", "我是thymeleaf");
        model.addAttribute("link", "http://www.baidu.com");
        return "thymeleaf";
    }
}
