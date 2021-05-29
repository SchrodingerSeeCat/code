package com.valid;

public class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void staticTest(String str) {
        System.out.println("father " + str);
    }

    public final void finalTest() {
        System.out.println("father final方法");
    }

    public void generalTest() {
        System.out.println("father 普通方法");
    }
}

class Son extends Father{
    public Son() {
        super();
    }

    // 不是重写的静态方法,因为静态方法不能被重写
    public static void staticTest(String str) {
        System.out.println("son " + str);
    }

    private void privateTest() {
        System.out.println("son 私有方法");
    }

    public void show() {
        // invokestatic
        staticTest("good");
        // invokestatic
        super.staticTest("hello");

        // invokevirtual
        privateTest();

        // invokespecial
        super.generalTest();

        // invokevirtual
        finalTest();

        // invokevirtual
        generalTest();
    }

    public void generalTest() {
        System.out.println("son 普通方法");
    }
}
