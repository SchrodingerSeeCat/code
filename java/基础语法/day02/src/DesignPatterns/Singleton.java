package DesignPatterns;
// 单例设计模式
public class Singleton {
    public static void main(String[] args) {

    }
}

// 饿汉式
//class Bank{
//
//    // 私有化类的构造器
//    private Bank() {
//
//    }
//
//    // 内部创建类的对象
//    private Bank instance = new Bank();
//
//    // 提供公共的方法，返回类的对象
//    public Bank getInstance(){
//        return instance;
//    }
//}

class Bank{
    // 私有化类的构造器
    private Bank() {

    }
    // 声明当前类对象，没有初始化
    private static Bank instance = null;

    // 声明public,static返回当前类对象的方法
    public static Bank getInstance(){
        instance = instance == null ? new Bank() : instance;
        return instance;
    }
}