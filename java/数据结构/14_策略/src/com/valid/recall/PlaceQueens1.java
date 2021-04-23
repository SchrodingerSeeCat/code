package com.valid.recall;

public class PlaceQueens1 {
    private int ways; //总共的摆法
    private int[] cols;

    public void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println("一共有: " + ways);
    }

    // 从第row行开始摆放皇后
    // cols索引是行号(从0开始)，数组元素是列号
    private void place(int row) {
        if (row == cols.length) {// 第8行说明已经找到一种摆法
            ways++;
            return;
        }

        for(int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
                // 回溯
            }
        }
    }

    // 判断第row行，第col列是否可以摆放皇后
    private boolean isValid(int row, int col) {
        for(int i = 0; i < row; i++) {
            if (cols[i] == col) return false; // 列冲突
            if (row - i == Math.abs(col - cols[i])) return false; // 对角线冲突
        }
        return true;
    }
}
