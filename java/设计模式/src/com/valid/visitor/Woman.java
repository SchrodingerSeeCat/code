package com.valid.visitor;

public class Woman implements Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
