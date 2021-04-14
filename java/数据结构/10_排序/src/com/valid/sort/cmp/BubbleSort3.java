package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class BubbleSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int sortIndex; // 记录最后一次交换的位置
        for(int end = array.length - 1; end > 0; end--) {
            sortIndex = 1;
            for(int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortIndex = begin;
                }
            }
            end = sortIndex;
        }
    }
}
