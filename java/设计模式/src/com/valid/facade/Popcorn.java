package com.valid.facade;

// 爆米花
public class Popcorn {
    private static final Popcorn instance = new Popcorn();
    private Popcorn() {}

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("爆米花打开");
    }
    public void off() {
        System.out.println("爆米花关闭");
    }
    public void pop() {
        System.out.println("出爆米花");
    }
}
