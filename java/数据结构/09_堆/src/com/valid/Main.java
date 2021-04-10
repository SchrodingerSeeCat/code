package com.valid;

import com.valid.heap.BinaryHeap;

public class Main {
    public static void main(String[] args) {
//        BinaryHeap<Integer> heap = new BinaryHeap<>();
//        System.out.println(heap);
//        heap.replace(0);
//        System.out.println(heap);
//        heap.add(68);
//        heap.add(72);
//        heap.add(43);
//        heap.add(50);
//        heap.add(38);
//        heap.add(10);
//        heap.add(90);
//        System.out.println(heap);
//        heap.remove();
//        System.out.println(heap);

//        System.out.println(heap);
//        heap.replace(0);
//        System.out.println(heap);

        BinaryHeap<Integer> heap = new BinaryHeap<>(new Integer[]{78, 59, 23, 10, 89, 100});
        System.out.println(heap);
    }
}