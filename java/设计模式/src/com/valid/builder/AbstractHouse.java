package com.valid.builder;

public abstract class AbstractHouse {
    protected abstract void buildBasic();
    protected abstract void buildWalls();
    protected abstract void roofed();
    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
