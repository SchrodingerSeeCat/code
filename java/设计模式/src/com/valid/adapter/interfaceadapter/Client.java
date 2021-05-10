package com.valid.adapter.interfaceadapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("接口适配器")
    public void testAbs() {
        AbsAdapter adapter = new AbsAdapter() {
            @Override
            public void operation1() {
                // 只需要重写要使用的方法即可
                System.out.println("使用了m1的方法");
            }
        };
        adapter.operation1();
    }
}
