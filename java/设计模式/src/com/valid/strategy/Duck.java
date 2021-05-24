package com.valid.strategy;

public abstract class Duck {
    protected FlyBehavior flyBehavior;

    public abstract void display(); // 显示鸭子信息

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
