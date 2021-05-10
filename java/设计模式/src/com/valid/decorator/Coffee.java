package com.valid.decorator;

// 用于提取单品咖啡的共有特点
public class Coffee extends Drink{
    @Override
    public double cost() {
        return super.getPrice();
    }
}
