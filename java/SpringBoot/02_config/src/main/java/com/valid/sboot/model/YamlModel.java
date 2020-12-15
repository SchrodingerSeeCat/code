package com.valid.sboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@ConfigurationProperties(prefix = "yaml")
public class YamlModel {
    private String str;
    private int num;
    private double Dnum;
    private Date birth;
    private List<String> list = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<String, String> map = new HashMap<>();

    public void setStr(String str) {
        this.str = str;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDnum(double dnum) {
        Dnum = dnum;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "YamlModel{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", Dnum=" + Dnum +
                ", birth=" + birth +
                ", list=" + list +
                ", users=" + users +
                ", map=" + map +
                '}';
    }
}
