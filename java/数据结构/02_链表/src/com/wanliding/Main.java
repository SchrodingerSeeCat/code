package com.wanliding;

public class Main {
    public static void main(String[] args) {
        BilateralCircleLinkList<Integer> list = new BilateralCircleLinkList<>();
        for (int i = 1; i <= 8; i++){
            list.add(i);
        }
        list.reset();
        while (list.size() != 0) {
            list.next();
            list.next();
            System.out.printf("%d ", list.remove());
        }
//        System.out.println(list);
//          1 2 3 4 5 6 7 8 9 10
    }
}
