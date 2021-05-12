package com.valid.visitor;

public class Fail implements Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男性给失败的评价...");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给失败的评价...");
    }
}
