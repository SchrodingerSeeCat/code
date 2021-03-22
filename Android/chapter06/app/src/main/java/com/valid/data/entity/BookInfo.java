package com.valid.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookInfo {
    @PrimaryKey // 主键
    @NonNull // 主键必须非空
    private String name; // 图书名称
    private String author; // 作者
    private String press; // 出版社
    private double price; // 价格

    @NonNull
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public double getPrice() {
        return price;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
