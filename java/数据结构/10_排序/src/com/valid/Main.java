package com.valid;

import com.valid.sort.count.CountingSort2;
import com.valid.sort.count.RadixSort;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{ 56, 9, 28, 37, 65 , 90, 78, 100, 10, 0 };
//
//        HeadSort<Integer> sort = new HeadSort<>();
//        sort.sort(array);
//
//        System.out.println(sort);

//        Student[] students = new Student[]{
//                new Student(18, 18, "Alice"),
//                new Student(18, 18, "王二"),
//                new Student(18, 39, "Tom"),
//                new Student(18, 40, "麻子"),
//        };
//        HeadSort<Student> sort = new HeadSort<>();
//        sort.sort(students);
//        System.out.println(sort);

//        InsertSort3<Integer> sort = new InsertSort3<>();
//        sort.sort(array);
//        System.out.println(sort);

//        MergeSort<Integer> sort = new MergeSort<>();
//        sort.sort(array);
//        System.out.println(sort);

//        QuickSort2<Integer> sort = new QuickSort2<>();
//        sort.sort(array);
//        System.out.println(sort);

//        ShellSort<Integer> sort = new ShellSort<>();
//        sort.sort(array);
//        System.out.println(sort);

//        CountingSort1 sort = new CountingSort1();
//        sort.sort(array);
//        System.out.println(sort);

//        CountingSort2 sort = new CountingSort2();
//        sort.sort(array);
//        System.out.println(sort);

        RadixSort sort = new RadixSort();
        sort.sort(array);
        System.out.println(sort);
    }
}
