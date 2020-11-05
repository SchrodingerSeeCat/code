import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class P_1160 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int row = n - 2 + 1;
        list.add(1);
        for(int i = 0; i < row; i++){
            int k = reader.nextInt();
            int p = reader.nextInt();
            int index = list.indexOf(k);
            if (p == 0) {
                list.add(index, i + 2);
            } else {
                list.add(index + 1, i + 2);
            }
        }
        int m = reader.nextInt();
        for(int i = 0; i < m; i++){
            int index = reader.nextInt();
            int temp = list.indexOf(index);
            if(temp != -1) {
                list.remove(temp);
            }
        }
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%d", list.get(i));
            if(i != list.size() - 1) {
                System.out.printf(" ");
            }
        }
    }
}
