package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class InsertSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E element = array[begin];
            while (cur > 0 && cmp(element, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = element;
        }
    }
}
