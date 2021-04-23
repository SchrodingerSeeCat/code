package com.valid.greedy;

import java.util.Arrays;

public class Load {
    public int maxNum(int capacity,  int[] treasure) {
        if (treasure == null) return 0;
        Arrays.sort(treasure);
        int weight = 0;
        for (int i = 0; weight < capacity && i < treasure.length; i++) {
            if (weight + treasure[i] < capacity) {
                weight += treasure[i];
            } else {
                return i;
            }
        }
        return treasure.length;
    }
}
