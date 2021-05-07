package com.valid.singleton.type7;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        System.out.println(singleton == Singleton.INSTANCE);
    }
}

// 懒汉式 枚举
enum Singleton {
    INSTANCE;
}
