package com.valid.sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E>{
    private E[] arr; // 用于合并时使用的临时数组

    @Override
    protected void sort() {
        arr = (E []) new Object[array.length >> 1];
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
        int li = 0, le = mid - begin, ri = mid;
        while (li < le && ri < end) {
            if (cmp(arr[li], array[ri]) <= 0) {
                array[begin] = arr[li++];
            } else {
                array[begin] = arr[ri++];
            }
            begin++;
        }

        while (li < mid) {
            array[begin++] = arr[li++];
        }

        while (ri < end) {
            array[begin++] = arr[ri++];
        }
    }
}
