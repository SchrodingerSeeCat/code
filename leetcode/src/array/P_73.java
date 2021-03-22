package array;

// https://leetcode-cn.com/problems/set-matrix-zeroes/
public class P_73 {
    public void setZeroes(int[][] matrix) {
        boolean row = false; // 标记第一行是否有0
        boolean col = false; // 标记第一列是否有0

        // 检查第一列
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                col = true;
            }
        }
        // 检查第一行
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                row = true;
            }
        }

        // 检查其他行以及列
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 将第一行及第一列中出现0的行和列至0
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 检查第一行是否有0
        if(row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        // 检查第一列是否有0
        if(col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
