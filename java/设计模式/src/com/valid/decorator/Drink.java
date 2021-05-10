package com.valid.decorator;

public abstract class Drink {
    private String description;
    private double price;

    // 子类实现
    public abstract double cost();

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
