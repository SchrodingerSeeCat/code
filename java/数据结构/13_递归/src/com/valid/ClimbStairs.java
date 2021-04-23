package com.valid;

/*
* 楼梯有n阶台阶，上楼可以一步上一阶，也可以一步上两阶，走完n阶楼梯共有多少种不同的走法？
* */
public class ClimbStairs {
    public static int climb(int n) {
        if (n <= 2) return n;
        return climb(n -1) + climb(n - 2);
    }
}
