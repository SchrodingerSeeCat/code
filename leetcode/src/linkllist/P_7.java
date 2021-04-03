package linkllist;

public class P_7 {
    public int reverse(int x) {
        long result = 0;
        int temp = 0;
        while(x != 0) {
            temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
            if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)result;
    }
}
