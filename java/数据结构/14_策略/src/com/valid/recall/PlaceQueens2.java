package com.valid.recall;

public class PlaceQueens2 {
    private int ways; //总共的摆法
    private boolean[] cols; // 标记着某一列是否有皇后
    private boolean[] leftTop; // 左上角到右下角是否有皇后
    private boolean[] rightTop; // 右上角到左下角是否有皇后

    // 初始化
    public void placeQueens(int n) {
        if (n < 1) return;
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
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
            if (cols[col]) continue; // 行冲突
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue; // 左斜线冲突
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue; // 友斜线冲突
            // 第row行第col列摆放皇后

            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);

            // 回溯
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }
}
