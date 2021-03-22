package com.valid.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Good {
    @PrimaryKey
    @NonNull
    private Integer id; // good的id
    private String name; // good的名称
    private Double price; // good的价格
    private String path; // 图片的路径

    @NonNull
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getPath() {
        return path;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
