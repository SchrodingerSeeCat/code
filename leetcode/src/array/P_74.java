package array;

// https://leetcode-cn.com/problems/search-a-2d-matrix/
public class P_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 1;
        while (i < matrix.length) {
            if (target == matrix[i][0]) {
                return true;
            } else if (target > matrix[i][0]) {
                if ((i + 1) != matrix.length) {
                    i++;
                } else {
                    break;
                }
            } else {
                i--;
                break;
            }
        }

        if (matrix.length == 1) i--;
        for(int j = 0; j < matrix[i].length; j++) {
            if (target == matrix[i][j]) {
                return true;
            }
        }
        return false;
    }
}
