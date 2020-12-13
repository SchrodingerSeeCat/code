package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {
        // 把用户信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        return "main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/loginout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("userLoginInfo");
        return "login";
    }
}
