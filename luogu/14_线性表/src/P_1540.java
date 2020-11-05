import java.util.LinkedList;
import java.util.Scanner;

public class P_1540 {
    public static void main(String[] args){
        LinkedList<Integer> queue = new LinkedList<>();
        Scanner reader = new Scanner(System.in);
        int m = reader.nextInt();
        int n = reader.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++){
            int temp = reader.nextInt();
            boolean flag = true;
            for(int j = 0; j < queue.size(); j++){
                if(temp == queue.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(queue.size() == m) {
                    queue.remove(0);
                }
                queue.add(temp);
                count++;
            }
        }
        System.out.print(count);
    }
}