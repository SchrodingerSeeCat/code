package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class QuickSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if ((end - begin) < 2) {
            return;
        }

        int mid = pivot(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivot(int begin, int end) {
        // 随机选取一个元素作为轴点
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        E element = array[begin];
        end--;
        while (begin < end) {
            while (begin < end && (cmp(array[end], element) > 0)) {
                // 右边元素大于轴点元素
                end--;
            }
            while (begin < end && (cmp(array[begin], element) < 0)) {
                // 左边的元素小于轴点元素
                begin++;
            }
            if(begin < end) {
                swap(begin, end);
            }
        }
        array[begin] = element;
        return begin;
    }
}
