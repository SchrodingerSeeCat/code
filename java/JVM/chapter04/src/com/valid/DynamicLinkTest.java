package com.valid;

public class DynamicLinkTest {
    private int num;
    public void methodA() {
        System.out.println("hahahhah");

        num++;
    }
    public void methodB() {
        methodA();
    }
}
