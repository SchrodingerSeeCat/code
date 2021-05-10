package com.valid.decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @DisplayName("测试装饰者模式")
    @Test
    public void test() {
        // 2份巧克力，一份牛奶的LongBlack
        Drink coffee = new LongBlack(); // 7

        coffee = new Milk(coffee); // 4

        coffee = new Chocolate(coffee); // 3
        coffee = new Chocolate(coffee); // 3

        System.out.println(coffee.cost());
        System.out.println(coffee.getDescription());
    }
}
