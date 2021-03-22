package com.valid.data.entity;

import java.util.Date;

public class UserInfo {
    private String name;
    private Integer age;
    private Double weight;
    private Integer height;
    private Boolean married;
    private Long updateTime;
    private String phone;
    private String password;

    public UserInfo(String name, Integer age, Double weight, Integer height, Boolean married, Long updateTime, String phone, String password) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.married = married;
        this.updateTime = updateTime;
        this.phone = phone;
        this.password = password;
    }

    public UserInfo() {

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getMarried() {
        return married;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
