package com.valid.iteratior;

import java.util.Iterator;

public interface College<E> {
    String getName();                               // 获取系名字
    void addDepartment(String name, String desc);   // 增加系
    Iterator<E> iterator();                         // 获取迭代器
}
