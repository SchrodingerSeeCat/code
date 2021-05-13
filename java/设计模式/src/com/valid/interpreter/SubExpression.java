package com.valid.interpreter;

import java.util.Map;

// 减法解释器
public class SubExpression extends SymbolExpression{

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    // 处理相减
    @Override
    public int interpreter(Map<String, Integer> var) {
        return left.interpreter(var) - right.interpreter(var);
    }
}
