package com.valid;

public class TailCall {
    public static int fac(int n) {
        return fac(n, 1);
    }

    private static int fac(int n, int result) {
        if (n <= 1) return result;
        return fac(n - 1, result * n);
    }
}
