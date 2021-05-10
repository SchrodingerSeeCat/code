package com.valid.builder.imporve;

// 抽象的建造者
public abstract class HouseBuilder {
    protected House house = new House();

    // 建造房子
    public abstract void buildBasic();
    public abstract void buildWall();
    public abstract void roofed();

    // 将房子返回
    public House build() {
        return house;
    }
}
