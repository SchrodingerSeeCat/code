import java.util.Scanner;

public class KMP {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String mainStr = reader.next();
        String sonStr = reader.next();
        System.out.println(bf(mainStr, sonStr, 0) + 1);
    }
    // BFÀ„∑®
    public static int bf(String mainStr, String sonStr, int pos) {
        int i = pos, j = 0;
        while(i < mainStr.length() && j < sonStr.length()) {
            if(mainStr.charAt(i) == sonStr.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= sonStr.length()) return i - sonStr.length();
        return -1;
    }

    // KMPÀ„∑®
    public static int kmp(int pos, String mainStr, String sonStr) {
        int[] next = findNext(new int[sonStr.length()], sonStr);
        int i = pos, j = 0;
        while(i < mainStr.length() && j < sonStr.length()) {
            if(j == 0 || sonStr.charAt(j) == mainStr.charAt(i)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if(j == sonStr.length()) return i - j;
        return -1;
    }
    private static int[] findNext(int[] next, String sonStr){
        int i = 1, j = 0;
        while(i < sonStr.length() - 1) {
            if(j == 0 || sonStr.charAt(i) == sonStr.charAt(j)) {
                i++;
                j++;
                if(sonStr.charAt(i) != sonStr.charAt(j)) next[i] = j;
                else next[i] = next[j];
            } else {
                j = next[j];
            }
        }
        return next;
    }
}