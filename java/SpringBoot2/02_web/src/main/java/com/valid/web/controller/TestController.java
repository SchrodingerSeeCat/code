package com.valid.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET-user";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser() {
        return "POST-user";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT-user";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-user";
    }
}
