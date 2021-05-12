package com.valid.visitor;

public class Man implements Person{
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
