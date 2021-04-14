package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class InsertSort3<E extends Comparable<E>> extends Sort<E> {
    // 二分搜索优化
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            E element = array[begin];
            int left = 0, right = begin, mid;
            // 查找合适的查找位置
            while (left < right) {
                mid = (left + right) >> 1;
                if (cmp(array[mid], element) > 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 所有比当前插入元素要小的元素后移一位
            for (int i = begin; i > left; i--) {
                array[i] = array[i - 1];
            }
            array[left] = element;
        }
    }
}
