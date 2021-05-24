package com.valid.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("策略模式")
    public void test() {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();
    }
}
