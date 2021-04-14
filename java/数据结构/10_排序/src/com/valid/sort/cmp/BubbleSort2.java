package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class BubbleSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        boolean flag = true; // 检测本次扫描是否有序
        for(int end = array.length - 1; end > 0; end--) {
            for(int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    cmp(begin, begin - 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
}
