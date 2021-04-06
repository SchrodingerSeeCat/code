package com.valid;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 56, 9, 28, 37, 65, 78, 90, 100 };

        new Main().selectSort(array);

        System.out.println(Arrays.toString(array));
    }
    // 冒泡排序
    public void bubbleSort1(int[] array) {
        int temp;
        for(int end = array.length - 1; end > 0; end--) {
            for(int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                }
            }
        }
    }
    public void bubbleSort2(int[] array) {
        int temp;
        boolean flag = true; // 检测本次扫描是否有序
        for(int end = array.length - 1; end > 0; end--) {
            for(int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public void bubbleSort3(int[] array) {
        int temp;
        int sortIndex; // 记录最后一次交换的位置
        for(int end = array.length - 1; end > 0; end--) {
            sortIndex = 1;
            for(int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sortIndex = begin;
                }
            }

            end = sortIndex;
        }
    }

    // 选择排序
    public void selectSort(int[] array) {
        int temp;
        int maxIndex;
        for(int end = array.length - 1; end > 0; end--) {
            maxIndex = 0;
            for(int begin = 1; begin <= end; begin++) {
                if (array[begin] > array[maxIndex]) {
                    maxIndex = begin;
                }
            }
            array[end] = array[maxIndex];
        }
    }
}
