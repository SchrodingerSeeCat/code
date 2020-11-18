import java.util.Scanner;
public class P_1428 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int []cute = new int[n];
        for (int i = 0; i < n; i++){
            cute[i] = reader.nextInt();
        }
        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < i; j++){
                if (cute[i] > cute[j]){
                    count++;
                }
            }
            System.out.printf("%d ", count);
        }
    }
}

