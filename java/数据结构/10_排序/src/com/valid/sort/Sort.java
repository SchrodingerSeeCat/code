package com.valid.sort;

import java.util.Arrays;

public abstract class Sort<E extends Comparable<E>>{

    protected E[] array; // 待排序的数组
    private int cmpCount; // 比较的次数
    private int swapCount; // 交换的次数

    public void sort(E[] array){
        if (array == null || array.length == 1) return;
        this.array = array;

        sort();
    }

    protected abstract void sort();

    /*
    * 返回值等于0，两个索引的值相等
    * 返回值小于0，第一个索引值小于第二个索引值
    * 返回值大于0，第一个索引值大于第二个索引值
    * */
    protected int cmp(int first, int second) {
        cmpCount++;
        return array[first].compareTo(array[second]);
    }

    // 比较元素
    protected int cmp(E first, E second) {
        cmpCount++;
        return first.compareTo(second);
    }
    protected void swap(int first, int second) {
        swapCount++;
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private boolean isStable() {
        return false;
    }
}
