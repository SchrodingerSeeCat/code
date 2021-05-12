package com.valid.visitor;

public class Success implements Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男性给成功的评价...");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给成功的评价...");
    }
}
