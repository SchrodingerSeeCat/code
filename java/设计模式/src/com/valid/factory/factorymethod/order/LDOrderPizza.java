package com.valid.factory.factorymethod.order;

import com.valid.factory.factorymethod.pizza.*;

public class LDOrderPizza extends OrderPizza{
    @Override
    public Pizza createPizza(String order) {
        if (order.equals("cheese")) return new LDCheesePizza();
        if (order.equals("greek")) return new LDGreekPizza();
        return null;
    }
}
