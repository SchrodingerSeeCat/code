import java.util.Scanner;
import java.util.Stack;

public class P_1449 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        int flag = 0;
        for(int i = 0; str.charAt(i) != '@'; i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }
            if (str.charAt(i) == '.' && (i - flag > 0)) {
                stack.add(Integer.parseInt(str.substring(flag,i)));
                flag = i + 1;
            } else{
                flag++;
                if(!stack.isEmpty() && stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    int temp = 0;
                    if (str.charAt(i) == '+') {
                        temp = second + first;
                    } else if(str.charAt(i) == '-') {
                        temp = second - first;
                    } else if(str.charAt(i) == '*') {
                        temp = second * first;
                    } else{
                        temp = second / first;
                    }
                    stack.add(temp);
                }
            }
        }
        System.out.println(stack.pop());
    }
}
