package com.valid.interpreter;

import java.util.Map;

// 变量的解释器
public class VarExpression implements Expression{
    private final String key;   // key是变量

    public VarExpression(String key) {
        this.key = key;
    }


    // 根据key返回对应的值
    @Override
    public int interpreter(Map<String, Integer> var) {
        return var.get(key);
    }
}
