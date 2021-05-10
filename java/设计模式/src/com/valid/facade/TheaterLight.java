package com.valid.facade;

// 灯光
public class TheaterLight {
    private static final TheaterLight instance = new TheaterLight();
    private TheaterLight() {}

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("灯光开启");
    }
    public void off() {
        System.out.println("灯光关闭");
    }

    public void up() {
        System.out.println("灯光调大");
    }
    public void down() {
        System.out.println("灯光调小");
    }
}
