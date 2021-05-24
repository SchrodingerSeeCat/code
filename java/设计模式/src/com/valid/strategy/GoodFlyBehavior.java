package com.valid.strategy;

public class GoodFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞行技术高超");
    }
}
