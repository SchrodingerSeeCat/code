package com.valid.sort.count;

import com.valid.sort.Sort;

public class CountingSort2 extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0], min = array[0];
        for(int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 存储每个整数出现的次数
        int[] counts = new int[max - min + 1];
        for(int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        // 累加前面的次数
        for(int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 排序
        int[] newArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }

        // 将排序好的数组拷贝至原数组
        for(int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
