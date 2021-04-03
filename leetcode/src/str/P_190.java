package str;

// https://leetcode-cn.com/problems/reverse-bits/
public class P_190 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            // n & 1 取得每一位的参数，并将它左移到固定的位数
            rev |= (n & 1) << (31 - i);

            // 将n的最低位舍去
            n >>>= 1;
        }
        return rev;
    }
}
