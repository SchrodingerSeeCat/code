package com.valid.demo1.controller;

import com.valid.demo1.entity.Users;
import org.apache.catalina.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Security";
    }

    @GetMapping("/index")
    public String index() {
        return "Hello index";
    }

    @GetMapping("/update")
//    @PreAuthorize("hasAnyAuthority('admins')")
    //    @Secured({"ROLE_sale", "ROLE_manager"})
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update() {
        System.out.println("============");
        return "Hello update";
    }

    @GetMapping("/users")
    @PostFilter("filterObject.username == 'tom'")
    public List<Users> getUsers() {
        List<Users> users = new LinkedList<>();
        users.add(new Users(1, "tom", "123"));
        users.add(new Users(2, "jack", "123"));
        users.add(new Users(3, "lucy", "123"));
        return users;
    }

    @PostMapping("/prefilter")
    @PreFilter("filterObject.id % 2 == 0")
    public List<Users> handlerUser(@RequestBody List<Users> users) {
        return users;
    }
}
