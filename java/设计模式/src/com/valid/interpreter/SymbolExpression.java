package com.valid.interpreter;

import java.util.Map;

// 抽象运算符号解析器，每个运算符号都只和自己左右两个数字有关
// 左右两个数字有可能也是一个解析的结果
public abstract class SymbolExpression implements Expression{
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract int interpreter(Map<String, Integer> var);
}
