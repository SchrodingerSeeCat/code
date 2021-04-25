package com.valid.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                min = Math.min(dp[i - coin], min);
            }
            dp[i] = min + 1;
        }
        return dp[amount];
    }

    // 求出所需的硬币的种类
    public int coins(int n){
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = new int[dp.length]; // 凑够i分时最后选择的硬币的面值
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1 && dp[i - 1] < min) {
                min = dp[i - 1];
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min) {
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min) {
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min) {
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
        }
        print(faces, n);
        return dp[n];
    }

    private void print(int[] faces, int n) {
        if (n < 1) return;
        System.out.println(faces[n]);
        print(faces, n - faces[n]);
    }
    // 递推(自底向上)
    public int coins3(int n){
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1];
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;
        }
        return dp[n];
    }
    // 记忆化搜索(自顶向下)
    public int coins2(int n) {
        if (n <= 0) return -1;
        int[] dp = new int[n + 1];

        int[] faces = {1, 5, 20, 25};
        for(int face : faces) {
            if (face > n) break;
            dp[face] = 1;
        }
        return coins2(n, dp);
    }
    private int coins2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) {
            dp[n] = Math.min(
                        Math.min(coins2(n - 25, dp), coins2(n - 20, dp)),
                        Math.min(coins2(n - 5, dp), coins2(n - 1, dp))
                    ) + 1;
        }
        return dp[n];
    }

    // 暴力递归
    public int coins1(int n) {
        if (n <= 0) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n ==1) return 1;

        return Math.min(
                Math.min(coins1(n - 25), coins1(n - 20)),
                Math.min(coins1(n - 5), coins1(n - 1))) + 1;
    }
}
