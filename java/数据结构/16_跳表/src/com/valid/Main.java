package com.valid;

import com.valid.skip.SkipList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Main {

    private final static int count = 10;
    private final static int data = 20;
    private final static SkipList<Integer, Integer> list = new SkipList<>();

    @DisplayName("测试")
    @Test
    public void test() {
        for (int i = 0; i < count; i++) {
            list.put(i, i + data);
        }
        for (int i = 0; i < count ;i++) {
            Assertions.assertEquals(i + data, list.get(i));
        }
        Assertions.assertEquals(list.size(), count);
        System.out.println(list);
        for (int i = 0; i < count; i++) {
            Assertions.assertEquals(i + data, list.remove(i));
        }
        Assertions.assertEquals(0, list.size());
    }
}
