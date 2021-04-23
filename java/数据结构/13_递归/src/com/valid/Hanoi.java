package com.valid;

public class Hanoi {
    // 将n个碟子从p1挪动到p3
    public static void hanoi(int n, String p1, String p2, String p3) {
        if (n <= 1) {
            move(n, p1, p3);
        } else {
            hanoi(n - 1, p1, p3, p2); // 将n-1个盘子从p1挪动到p2
            move(n, p1, p3);
            hanoi(n- 1, p2, p1, p3);
        }
    }

    private static void move(int num, String from, String to) {
        System.out.println(num + ": " + from + "->" + to);
    }
}
