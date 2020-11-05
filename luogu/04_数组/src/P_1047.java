import java.util.Scanner;

public class P_1047 {
    public static void main(String[] args) {
        int l, m, sum = 0;
        Scanner reader = new Scanner(System.in);
        l = reader.nextInt();
        m = reader.nextInt();
        int[][] area = new int[m][2];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < 2; j++){
                area[i][j] = reader.nextInt();
            }
        }
        for (int i = 0; i <= l; i++){
            for (int j = 0; j < m; j++){
                if (i >= area[j][0] && i <= area[j][1]) {
                    sum++;
                    break;
                }
            }
        }
        System.out.println(l - sum + 1);
    }
}
