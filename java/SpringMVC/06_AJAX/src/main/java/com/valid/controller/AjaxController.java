package com.valid.controller;

import com.valid.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @GetMapping("/t1")
    public String test() {
        return "hello";
    }

    @PostMapping("/ajax")
    public String ajax(String name){
        return "ajax test";
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> list = new ArrayList<>();
        list.add(new User("石昊", 3, "男"));
        list.add(new User("叶凡", 30, "男"));
        list.add(new User("狠人大帝", 18, "女"));
        return list;
    }

    @PostMapping("/a3")
    public String a3(String name, String pwd){
        String sb = "";
        if(name != null) {
            if("admin".equals(name)) {
                sb = "ok";
            } else {
                sb = "用户名有误";
            }
        }
        if(pwd != null) {
            if("123456".equals(pwd)) {
                sb = "ok";
            } else {
                sb = "密码有误";
            }
        }
        return sb;
    }
}
