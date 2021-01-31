package com.valid.admin.controller;

import com.valid.admin.bean.Account;
import com.valid.admin.bean.City;
import com.valid.admin.bean.User;
import com.valid.admin.service.AccountService;
import com.valid.admin.service.CityService;
import com.valid.admin.service.impl.AccountServiceImpl;
import com.valid.admin.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CityService cityService;

    @Autowired
    private AccountService accountService;

    // 返回登录页面(即login页面)
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    // 登录
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if(StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            // 保存登录成功的用户
            session.setAttribute("loginUser", user);

            // 登录成功重定向到main.html
            // 默认为转发，如果转发的话会出现表单重复提交的问题
            return "redirect:/main.html";
        }

        // 登录失败放入msg 在页面中取出
        model.addAttribute("msg", "账号密码错误");
        return "login";
    }

    // 解决表单重复提交的问题
    @GetMapping("/main.html")
    public String mainPage(Model model, HttpSession session) {

        // 将redis统计的数字放入到主页
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        String main = operations.get("/main.html");
        String sql = operations.get("/sql");
        model.addAttribute("main", main);
        model.addAttribute("sql", sql);
        return "main";
    }

    @ResponseBody
    @GetMapping("/account")
    public Account getAccountById(@RequestParam("id") Long id) {
        return accountService.getAccountById(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getCityById(id);
    }

    @ResponseBody
    @PostMapping("/insert")
    public City insertCity(City city) {
        cityService.insertCity(city);
        return city;
    }
}
