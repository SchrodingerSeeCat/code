package com.valid;

import com.valid.bloom.BloomFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Main {
    BloomFilter<Integer> bf = new BloomFilter<>(10000000, 0.01);

    @DisplayName("测试参数")
    @Test
    public void testParams() {
        BloomFilter<String> bf = new BloomFilter<>(100_0000, 0.01);
//        for (int i = 0; i < 100_0000; i++) {
//            bf.put(i);
//        }
//        for (int i = 0; i < 500; i++) {
//            System.out.println(i+ ": " + bf.contains(i));
//        }
//        for (int i = 6000; i < 6500; i++) {
//            System.out.println(i + ": " + bf.contains(i));
//        }
        bf.put("ABC");
        System.out.println(bf.contains("ABC"));
    }
}
