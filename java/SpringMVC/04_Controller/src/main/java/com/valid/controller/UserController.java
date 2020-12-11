package com.valid.controller;

import com.valid.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    // http://192.168.1.108:8080/s4/hello?name=hahah
    @RequestMapping("/hello")
    public String hello(String name) {
        // 普通参数
        System.out.println(name);
        return "test";
    }

    // http://192.168.1.108:8080/s4/different?username=hahha
    @RequestMapping("/different")
    public String test(@RequestParam("username") String name) {
        // 前端参数名与方法参数名不同
        System.out.println(name);
        return "test";
    }

    // http://localhost:8080/s4/object?id=1&name=haha&age=18
    @RequestMapping("/object")
    public String test1(User user) {
        // 前端返回对象
        System.out.println(user);

        return "test";
    }

    @RequestMapping("/modelmap")
    public String test2(ModelMap map) {
        map.addAttribute("msg", "ModelMap");

        return "test";
    }
}
