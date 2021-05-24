package com.valid.strategy;

public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞行技术不行");
    }
}
