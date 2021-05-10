package com.valid.decorator;

public class Milk extends Decorator{

    public Milk(Drink drink) {
        super(drink);
        setDescription("牛奶 ");
        setPrice(4.0);
    }
}
