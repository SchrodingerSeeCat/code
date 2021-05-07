package com.valid.factory.simple.pizzastore.order;

import com.valid.factory.simple.pizzastore.pizza.CheesePizza;
import com.valid.factory.simple.pizzastore.pizza.GreekPizza;
import com.valid.factory.simple.pizzastore.pizza.Pizza;

import java.util.Scanner;

public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        String name = "";
//        Scanner scanner = new Scanner(System.in);
//        tag:while (true) {
//            name = scanner.next();
//            switch (name) {
//                case "cheese":
//                    pizza = new CheesePizza();
//                    pizza.setName("奶酪披萨");
//                    break;
//                case "greek":
//                    pizza = new GreekPizza();
//                    pizza.setName("希腊披萨");
//                    break;
//                default:
//                    break tag;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }
//    }

    // 定义一个简单工厂对象
    private final SimpleFactory simpleFactory = new SimpleFactory();
    public OrderPizza() {
        String orderType = "";
        Pizza pizza = null;
        Scanner scanner = new Scanner(System.in);
        do {
            orderType = scanner.next();
            pizza = simpleFactory.createPizza(orderType);

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
}
