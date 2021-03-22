package stack;

import java.util.Stack;

// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class P_150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int result = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") ||
                tokens[i].equals("-") ||
                tokens[i].equals("*") ||
                tokens[i].equals("/")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    default:
                        result = first / second;
                }
                stack.push(result + "");
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
