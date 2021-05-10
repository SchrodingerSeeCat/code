package com.valid.factory.factorymethod.order;

import com.valid.factory.factorymethod.pizza.BJCheesePizza;
import com.valid.factory.factorymethod.pizza.BJGreekPizza;
import com.valid.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{
    @Override
    public Pizza createPizza(String order) {
        if (order.equals("cheese")) return new BJCheesePizza();
        if (order.equals("greek")) return new BJGreekPizza();
        return null;
    }
}
