package com.valid.factory.absfactory.order;

import com.valid.factory.absfactory.pizza.BJCheesePizza;
import com.valid.factory.absfactory.pizza.BJGreekPizza;
import com.valid.factory.absfactory.pizza.Pizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) return new BJCheesePizza();
        if (type.equals("greek")) return new BJGreekPizza();
        return null;
    }
}
