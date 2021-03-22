package str;

// https://leetcode-cn.com/problems/number-of-1-bits/
public class P_191 {
    public int hammingWeight(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
