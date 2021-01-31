package com.valid.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.valid.admin.bean.User;
import com.valid.admin.mapper.UserMapper;
import com.valid.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/*
* 实现table的页面跳转
* */

@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        int i = 10 / 0;
        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") int pn, Model model){
        // 表格内容的遍历
        List<User> users = Arrays.asList(
            new User("张三", "999999"),
            new User("李四", "asdfdd"),
            new User("王二", "asdfsa"),
            new User("麻子", "dfhgdf")
        );
        model.addAttribute("users", users);


        // 从数据库中拿出数据
//        List<User> list = userService.list();
//        model.addAttribute("list", list);

        // 查询分页数据
        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Long pn,
                             RedirectAttributes ra) {
        userService.removeById(id);

        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }
}
