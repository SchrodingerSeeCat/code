package com.valid.facade;

// 荧幕
public class Screen {
    private static final Screen instance = new Screen();
    private Screen() {}

    public static Screen getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("屏幕打开");
    }
    public void off() {
        System.out.println("屏幕关闭");
    }
}
