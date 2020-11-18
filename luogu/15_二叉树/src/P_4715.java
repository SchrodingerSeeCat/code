/*
*https://www.luogu.com.cn/problem/P4715
* */

import java.util.Scanner;

public class P_4715{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int num = (int)Math.pow(2, n);
        int[] team = new int[num];
        boolean[] win = new boolean[num];
        for(int i = 0; i < num; i++) {
            team[i] = reader.nextInt();
        }
        for(int i = 0; i < n -1; i++) {
            select(num, team, win);
        }
        int first = -1;
        for(int j = 0; j < num; j++) {
            if (!win[j]) {
                if (first == -1) {
                    first = j;
                } else {
                    if (team[first] > team[j]) {
                        System.out.println(j + 1);
                    } else {
                        System.out.println(first + 1);
                    }
                    return;
                }
            }
        }
    }
    public static void select(int num, int[]team, boolean[] win) {
        int first = -1;
        for(int j = 0; j < num; j++) {
            if (!win[j]) {
                if (first == -1) {
                    first = j;
                } else if (first != -1) {
                    if (team[first] > team[j]) {
                        win[j] = true;
                    } else {
                        win[first] = true;
                    }
                    first = -1;
                }
            }
        }
    }
}