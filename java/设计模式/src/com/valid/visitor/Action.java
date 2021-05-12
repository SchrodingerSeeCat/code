package com.valid.visitor;

public interface Action {
    // 得到男性的评测
    void getManResult(Man man);
    // 获取女性的评测
    void getWomanResult(Woman woman);
}
