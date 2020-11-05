import java.util.ArrayList;
import java.util.Scanner;
public class P_1427 {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner reader = new Scanner(System.in);
        while(true){
            int temp = reader.nextInt();
            if (temp == 0){
                break;
            }
            arr.add(temp);
        }
        for (int i = arr.size() - 1; i >= 0 ; i--){
            System.out.printf("%d ", arr.get(i));
        }
    }
}
