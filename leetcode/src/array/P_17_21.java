package array;

public class P_17_21 {
    public int trap(int[] height) {
        int count = 0, sum = 0, i = 0, j = height.length - 1, k = 1;
        for (int value : height) {
            sum = sum + value;
        }
        while (i <= j) {
            while (i <= j && height[i] < k) {
                i++;
            }
            while (i <= j && height[j] < k) {
                j--;
            }
            count = count + j - i + 1;
            k++;
        }
        return count - sum;
    }
}
