package com.valid.jdbc.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Actor {
    private int id;
    private String name;
    private String sex;
    private Timestamp borndate;
    private String phone;
}
