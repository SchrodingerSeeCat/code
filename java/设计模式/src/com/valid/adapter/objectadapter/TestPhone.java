package com.valid.adapter.objectadapter;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPhone {

    @DisplayName("测试对象适配器模式")
    @Test
    public void testPhone() {
        Phone phone = new Phone();

        phone.charging(new VoltageAdapter(null));
    }
}
