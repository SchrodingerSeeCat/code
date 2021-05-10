package com.valid.facade;

// 投影仪
public class Projector {
    private static final Projector instance = new Projector();
    private Projector() {}

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("投影仪打开");
    }
    public void off() {
        System.out.println("投影仪关闭");
    }
    public void focus() {
        System.out.println("正在聚焦");
    }
}
