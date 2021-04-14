package com.valid.sort.cmp;

import com.valid.sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence(); // 步长序列
        System.out.println(stepSequence);
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    // 分成step进行排序
    private void sort(int step) {
        // col第几列
        for(int col = 0; col < step; col++) {
            // 插入排序对每一列进行排序
            for (int begin = col + step; begin < array.length; begin+=step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur = cur - step;
                }
            }
        }
    }

    // 生成步长序列
//    private List<Integer> shellStepSequence() {
//        List<Integer> stepSequence = new ArrayList<>();
//        int step = array.length;
//
//        while ((step = (step >> 1)) > 0) {
//            stepSequence.add(step);
//        }
//        return stepSequence;
//    }

    // 第二种生成步长序列
    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = 0, k = 0;

        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }

            if (step >= array.length) break;
            stepSequence.add(step);
            k++;
        }
        return stepSequence;
    }
}
