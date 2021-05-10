package com.valid.facade;

// 立体声音响
public class Stereo {
    private static final Stereo instance = new Stereo();
    private Stereo() {}

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("立体声音响开启");
    }
    public void off() {
        System.out.println("立体声音响关闭");
    }

    public void up() {
        System.out.println("音量调大");
    }
    public void down() {
        System.out.println("音量调小");
    }
}
