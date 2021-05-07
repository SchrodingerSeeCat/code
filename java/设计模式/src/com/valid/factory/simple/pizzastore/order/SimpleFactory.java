package com.valid.factory.simple.pizzastore.order;

import com.valid.factory.simple.pizzastore.pizza.CheesePizza;
import com.valid.factory.simple.pizzastore.pizza.GreekPizza;
import com.valid.factory.simple.pizzastore.pizza.Pizza;

// 简单工厂类
public class SimpleFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
                break;
            case "greek":
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
                break;
        }
        return pizza;
    }
}
