package com.valid.mediator;

public interface Mediator {
    void register(String name, Colleague colleague);
    void getMessage(int stateChange, String name);
    void sendMessage();
}
