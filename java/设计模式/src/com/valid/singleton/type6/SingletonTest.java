package com.valid.singleton.type6;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton == Singleton.getInstance());
    }
}

// 懒汉式 静态内部类
class Singleton {
    // 1.构造器私有化
    private Singleton() {}

    private static class SingletonInstance {
        private final static Singleton INSTANCE = new Singleton();
    }

    // 3.提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
