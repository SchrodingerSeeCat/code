package com.valid.sort.count;

import com.valid.sort.Sort;

public class RadixSort extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找最大值，确定要进行几次基数排序
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        for(int radix = 1; radix <= max; radix *= 10) {
            countingSort(radix);
        }
    }

    private void countingSort(int radix) {
        // 存储每个整数出现的次数
        int[] counts = new int[10];
        for(int i = 0; i < array.length; i++) {
            counts[array[i] / radix % 10]++;
        }
        // 累加前面的次数
        for(int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 排序
        int[] newArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] / radix % 10]] = array[i];
        }

        // 将排序好的数组拷贝至原数组
        for(int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
