package com.valid.interpreter;

import java.util.Map;
import java.util.Stack;

public class Calculator {
    private final Expression expression;

    public Calculator(String exp) { // exp 要求值的表达式
        Stack<Expression> stack = new Stack<>();

        // 表达式拆分为数组
        char[] chars = exp.toCharArray();

        // 左右置空
        Expression left = null;
        Expression right = null;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(chars[i])));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    public int run(Map<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
