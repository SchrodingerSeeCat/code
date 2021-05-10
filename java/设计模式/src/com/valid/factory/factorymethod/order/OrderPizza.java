package com.valid.factory.factorymethod.order;


import com.valid.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

public abstract class OrderPizza {
    public OrderPizza() {
        String orderType = "";
        Pizza pizza = null;
        Scanner scanner = new Scanner(System.in);
        do {
            orderType = scanner.next();
            pizza = createPizza(orderType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                break;
            }
        } while (true);
    }

    public abstract Pizza createPizza(String order);
}
