import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] turnover = new int[n];
        turnover[0] = reader.nextInt();
        int sum = turnover[0];
        for(int i = 1; i < n; i++){
            turnover[i] = reader.nextInt();
            Arrays.sort(turnover, 0, i);
            sum = sum + Math.min(Math.abs(turnover[i] - turnover[0]), Math.abs(turnover[i] - turnover[i - 1]));
        }
        System.out.println(sum);
    }
}
