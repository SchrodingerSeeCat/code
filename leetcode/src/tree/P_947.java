package tree;
/*
* https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
* */
public class P_947 {
    public int removeStones(int[][] stones) {
        // 移除的石头的总数
        int sum = 0;
        boolean[] flag = new boolean[stones.length];
        for(int i = 0; i < stones.length - 1; i++) {
            for(int j = i + 1; j < stones.length; j++) {
                if(!flag[i] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                    sum++;
                    flag[i] = true;
                    break;
                }
            }
        }
        return sum;
    }
}
