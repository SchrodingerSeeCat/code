package com.valid.factory.absfactory.order;

import com.valid.factory.absfactory.pizza.Pizza;

// 抽象工厂模式的抽象层
public interface AbsFactory {
    Pizza createPizza(String type);
}
