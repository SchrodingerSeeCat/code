import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String a = "abcbdb";
        String b = "acbbabdbb";
        int[][] arr = new int[a.length() + 1][b.length() + 1];
        lcs(a, b, arr);
    }

    public static void lcs(String a, String b, int[][] arr) {
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        print(arr, a);
    }

    public static void print(int[][] arr, String str){
        Stack<Integer> stack = new Stack<>();
        int row = arr.length - 1;
        int col = arr[0].length - 1;
        while(row != 0 && col != 0) {
            if(arr[row][col] == arr[row][col - 1]) {
                col--;
            } else if(arr[row][col] == arr[row - 1][col]) {
                row--;
            } else {
                row--;
                col--;
                stack.push(row);
            }
        }
        while(!stack.isEmpty()) {
            System.out.printf("%s", str.charAt(stack.pop()));
        }
    }
}
