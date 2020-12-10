package com.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectForward {
    // 重定向和转发 需要将视图解析器注释

    @RequestMapping("/t1")
    public String test1(Model model) {
        // 转发
        model.addAttribute("msg", "转发");
//        return "/WEB-INF/jsp/test.jsp";

        // 也可以通过指定forward前缀进行转发
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/t2")
    public String test2(Model model) {
        // 重定向
        model.addAttribute("msg", "重定向");
        return "redirect:/index.jsp";
    }
}
