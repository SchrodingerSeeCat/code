package com.valid.template;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("模板模式")
    public void test() {
        System.out.println("===制作红豆豆浆===");
        SoyMilk redSoyMilk = new RedSoyMilk();
        redSoyMilk.make();

        System.out.println("===制作花生豆浆===");
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
