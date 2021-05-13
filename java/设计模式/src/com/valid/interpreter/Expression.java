package com.valid.interpreter;

import java.util.Map;

// 抽象类表达式
// 通过Map键值对可以获取到变量的值
public interface Expression {
    int interpreter(Map<String, Integer> var);
}
