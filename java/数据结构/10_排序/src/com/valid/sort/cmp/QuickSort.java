package com.valid.sort.cmp;

import com.valid.sort.Sort;

public class QuickSort <E extends Comparable<E>> extends Sort<E> {
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
        E element = array[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                // 右边元素大于轴点元素
                if (cmp(array[end], element) > 0) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                // 左边的元素小于轴点元素
                if (cmp(array[begin], element) < 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        array[begin] = element;
        return begin;
    }
}
