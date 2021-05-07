package com.valid.singleton.type1;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton == Singleton.getInstance());
    }
}
// 饿汉式静态变量
class Singleton {
    // 1.构造器私有化
    private Singleton() {}

    // 2.类的内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3.提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
