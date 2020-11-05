import java.util.Scanner;

public class P_5728 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int count = 0;
        int[][] score = new int[n][3];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 3; j++){
                score[i][j] = reader.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++){
            int sum = score[i][0] + score[i][1] + score[i][2];
            for (int j = i + 1; j < n; j++){
                int next = score[j][0] + score[j][1] + score[j][2];
                if (Math.abs(sum - next) <= 10 ) {
                    int k = 0;
                    for(; k < 3; k++){
                        if (!P_5728.problemAnswer(score[i][k], score[j][k])){
                            break;
                        }
                    }
                    if (k == 3) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        reader.close();
    }
    public static boolean problemAnswer(int a, int b) {
        return Math.abs(a - b) <= 5;
    }
}
