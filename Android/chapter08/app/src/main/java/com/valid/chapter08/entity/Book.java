package com.valid.chapter08.entity;

import com.valid.chapter08.R;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int pic;
    private String desc;

    public static List<Book> getDefaultList() {
        List<Book> list = new LinkedList<>();

        list.add(new Book(R.drawable.adv, "广告一号"));
        list.add(new Book(R.drawable.adv2, "广告二号"));
        list.add(new Book(R.drawable.adv3, "广告三号"));
        list.add(new Book(R.drawable.adv4, "广告四号"));
        list.add(new Book(R.drawable.adv5, "广告五号"));
        list.add(new Book(R.drawable.adv6, "广告六号"));
        return list;
    }
}
