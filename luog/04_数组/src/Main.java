import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[][] arr = new int[n + 1][7];
        int[] score = new int[7];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 7; j++){
                arr[i][j] = reader.nextInt();
            }
        }
        for(int i = 1; i <= n; i++){
            for (int j = 0; j < 7; j++){
                for (int k = 0; k < 7; k++){
                    if (arr[i][j] == arr[0][k]) {
                        score[k]++;
                    }
                }
            }
        }
        for(int i = 0; i < 7; i++){
            System.out.println(score[i]);
        }
    }
}
