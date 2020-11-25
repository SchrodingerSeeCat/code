/*
* 归并排序
* */

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {9, 5, 0, 3, 2, 7, 4, 1, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int begin, int end) {
        if(begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];

        int i = begin, j = mid + 1, k = 0;
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i = 0; i < temp.length; i++) {
            arr[begin + i] = temp[i];
        }
    }
}
