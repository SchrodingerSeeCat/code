import java.util.ArrayList;
import java.util.Scanner;

public class P_1196 {
    public static void main(String[] args) {
        ArrayList<Integer> circle = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        for(int i = 1; i <= n; i++){
            circle.add(i);
        }
        int i = 0;
        while(!circle.isEmpty()) {
            if (circle.size() == 1) {
                i = 0;
            } else {
                i = (i + m - 1) % circle.size();
            }
            System.out.printf("%d ", circle.remove(i));
        }
    }
}
