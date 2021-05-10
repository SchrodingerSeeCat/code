package com.valid.decorator;

public class Chocolate extends Decorator{

    public Chocolate(Drink drink) {
        super(drink);
        setDescription("巧克力 ");
        setPrice(3.0);
    }
}
