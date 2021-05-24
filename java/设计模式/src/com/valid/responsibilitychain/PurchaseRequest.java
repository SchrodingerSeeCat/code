package com.valid.responsibilitychain;

// 请求类
public class PurchaseRequest {
    private int type;       // 请求类型
    private double price;   // 请求金额
    private int id;

    public PurchaseRequest(int type, double price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
