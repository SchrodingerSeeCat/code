package com.valid.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {

        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);

        return "forward:/success"; //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg, HttpServletRequest request) {
        // 两种方式取出attribute
        // 1. @RequestAttribute
        // 2. 原生Servlet

        Object servlet = request.getAttribute("msg");
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");

        Map<String, Object> map = new HashMap<>();
        map.put("servlet", servlet);
        map.put("@RequestAttribute", msg);
        map.put("hello", hello);
        map.put("world", world);

        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        // 对于请求参数中的map、model、HttpServletRequest类型的数据都会被放入到请求上下文中

        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("msg", "HelloWorld");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);

        return "forward:/success";
    }
}
