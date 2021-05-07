package com.valid.singleton.type4;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton == Singleton.getInstance());
    }
}

// 懒汉式 线程安全
class Singleton {
    // 1.构造器私有化
    private Singleton() {}

    // 2.类的内部创建对象实例
    private static Singleton instance;

    // 3.提供一个共有的静态方法，返回实例对象
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
