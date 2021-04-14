package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] arr; // 用于合并时使用的临时数组

    @Override
    protected void sort() {
        arr = (E []) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    // 归并排序
    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);

        merge(begin, mid, end);
    }
    // 对[begin, mid)和[mid, end)范围合并成一个有序序列
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;

        // 备份数组
        for(int i = li; i < le; i++) {
            arr[i] = array[begin + i];
        }
        while (li < le) {
            if (mid < end && cmp(arr[li], array[mid]) > 0) {
                array[begin++] = array[mid++];
            } else {
                array[begin++] = arr[li++];
            }
        }
    }
}
