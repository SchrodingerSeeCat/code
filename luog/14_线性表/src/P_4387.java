import java.util.Scanner;
import java.util.Stack;

public class P_4387 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int q = reader.nextInt();
        int[] first;
        int[] second;
        int firstIndex = 0;
        int secondIndex = 0;
        while(q-- != 0){
            int n = reader.nextInt();
            first = new int[n];
            second = new int[n];
            Stack<Integer> stack = new Stack<>();
            System.gc();
            for(int i = 0; i < n; i++){
                first[i] = reader.nextInt();
            }
            for(int i = 0; i < n; i++){
                second[i] = reader.nextInt();
            }
            firstIndex = 0;
            secondIndex = 0;
            while(firstIndex < n || secondIndex < n){
                if(!stack.isEmpty() && stack.peek() == second[secondIndex]) {
                    stack.pop();
                    secondIndex++;
                } else if(firstIndex < n){
                    stack.add(first[firstIndex]);
                    firstIndex++;
                } else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            stack.clear();
        }
    }
}
