package com.valid.builder;

public class CommonHouse extends AbstractHouse{
    @Override
    protected void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    protected void roofed() {
        System.out.println("普通房子封顶");
    }
}
