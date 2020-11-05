/*
* 0-1背包蛮力算法
* */
public class Main {
    public static void main(String[] args){
        int[] price = {24, 2, 9, 10, 9};
        int[] capArr = {10, 3, 4, 5, 4};
        System.out.println(knapsackSR(4, 13, capArr, price));

        int[][] cache = new int[6][14];
        System.out.println(knapsackMR(4, 13, capArr, price, cache));
    }
    public static int knapsackSR(int end, int cap, int[] capArr, int[] price){
        if (cap < 0) return -1;
        if (end <= 0) return 0;
        // 选择商品p的情况
        int p1 = knapsackSR(end - 1, cap - capArr[end], capArr, price);
        // 未选择商品p的情况
        int p2 = knapsackSR(end - 1, cap, capArr, price);
        if(p1 == -1 && p2 == -1){
            return 0;
        } else if (p1 != -1 && p2 != -1) {
            return Math.max(p1 + price[end], p2);
        } else if(p1 == -1){
            return p2;
        }
        return p1 + price[end];
    }

    public static int knapsackMR(int end, int cap, int[] capArr, int[] price, int[][] cache){
        if (cap < 0) return -1;
        if (end <= 0) return 0;
        if (cache[end][cap] != 0) {
            return;
        }
        // 选择商品p的情况
        int p1 = knapsackSR(end - 1, cap - capArr[end], capArr, price);
        // 未选择商品p的情况
        int p2 = knapsackSR(end - 1, cap, capArr, price);
        cache[end][cap] = Math.max()
    }
}
