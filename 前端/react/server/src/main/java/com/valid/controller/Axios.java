package com.valid.controller;

import com.alibaba.fastjson.JSON;
import com.valid.pojo.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Axios {

    @RequestMapping("/student")
    public String Student() {
        Student[] students = new Student[]{
                new Student("001", "tom", 18),
                new Student("002", "jerry", 19),
                new Student("003", "tony", 120)
        };
        return JSON.toJSONString(students);
    }
}
