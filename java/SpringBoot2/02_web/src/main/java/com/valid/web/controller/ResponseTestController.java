package com.valid.web.controller;

import com.valid.web.bean.Person;
import com.valid.web.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class ResponseTestController {


    /*
    * 1. 浏览器发送请求直接返回xml
    * 2. ajax发送请求 返回json
    * 3. app发送请求 返回自定义的数据
    *
    * 步骤：
    * 1. 添加自定义的MessageConverter
    * 2. 系统底层会统计出所有的MessageConverter能操作哪些类型
    * 3. 客户端内容协商
    * */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person("张三", 18, new Date(), new Pet("大黄", 180));
        return person;
    }
}
