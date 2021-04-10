package com.valid.sort;

public class SelectionSort<E extends Comparable<E>> extends Sort<E>{
    @Override
    protected void sort() {
        int maxIndex;
        for(int end = array.length - 1; end > 0; end--) {
            maxIndex = 0;
            for(int begin = 1; begin <= end; begin++) {
                if (cmp(begin, maxIndex) > 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }
}
