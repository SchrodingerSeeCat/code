package com.valid.factory.absfactory.pizza;

public class BJGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京希腊披萨");
        System.out.println("北京希腊披萨 准备原材料");
    }
}
