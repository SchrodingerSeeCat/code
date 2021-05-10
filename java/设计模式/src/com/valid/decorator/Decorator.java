package com.valid.decorator;

// 装饰器
public class Decorator extends Drink{
    private final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        // 自己的价格加上调料的价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " "
                + super.getPrice() + " "
                + drink.getDescription();
    }
}
