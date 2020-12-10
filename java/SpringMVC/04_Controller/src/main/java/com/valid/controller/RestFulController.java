package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    // http://localhost:8080/s4/add?a=1&b=2
    @RequestMapping("/add")
    public String test(int a, int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "test";
    }

    // http://localhost:8080/s4/add/1/2
//    @RequestMapping(path = "/add/{a}/{b}", method = RequestMethod.POST)
//    public String test1(@PathVariable int a,@PathVariable int b, Model model) {
//        int res = a + b;
//        model.addAttribute("msg", "结果为" + res);
//        return "test";
//    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "test";
    }
}
