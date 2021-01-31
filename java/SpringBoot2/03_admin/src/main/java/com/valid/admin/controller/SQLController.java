package com.valid.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQLController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public int sql(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
    }
}
