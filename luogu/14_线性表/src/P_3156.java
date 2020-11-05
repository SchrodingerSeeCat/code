import java.util.Scanner;

public class P_3156 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] student = new int[2000001];
        for (int i = 0; i < n; i++){
            student[i] = reader.nextInt();
        }
        for (int i = 0; i < m; i++){
            System.out.println(student[reader.nextInt() - 1]);
        }
    }
}
