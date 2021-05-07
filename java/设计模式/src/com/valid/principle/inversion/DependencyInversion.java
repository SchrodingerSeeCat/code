package com.valid.principle.inversion;

// 依赖倒转
public class DependencyInversion {
    public static void main(String[] args) {
        new Person().receive(new Email());
    }
}

interface Receiver {
    String getInfo();
}

class Email implements Receiver{
    public String getInfo() {
        return "电子邮件信息: Hello, World";
    }
}

class WeChat implements Receiver{
    public String getInfo() {
        return "电子邮件信息: Hello, World";
    }
}

class Person {
    public void receive(Receiver receiver) {
        System.out.println(receiver.getInfo());
    }
}