package com.valid.strategy;

public class PekingDuck extends Duck{

    public PekingDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭不能飞行");
    }
}
