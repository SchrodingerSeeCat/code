package com.valid.sort.count;

import com.valid.sort.Sort;

public class CountingSort1 extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 存储每个整数出现的位置
        int[] counts = new int[max + 1];
        for(int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        // 排序
        for(int i = 0, k = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                array[k++] = i;
                counts[i]--;
            }
        }
    }
}
