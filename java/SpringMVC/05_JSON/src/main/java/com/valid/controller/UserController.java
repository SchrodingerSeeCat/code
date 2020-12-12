package com.valid.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.valid.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @RequestMapping("/json")
    @ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String jsonTest() throws JsonProcessingException {
        // 创建一个对象
        User user = new User("张三", 18, true);

        // jackson，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/json2")
    @ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String jsonTest2() throws JsonProcessingException {
        // jackson，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 关闭默认返回的时间格式
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);

        // 自定义时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(new Date());
    }

    @RequestMapping("/json3")
    @ResponseBody
    public String jsonTest3(){
        User user = new User("李四", 18, false);

        return JSON.toJSONString(user);
    }
}
