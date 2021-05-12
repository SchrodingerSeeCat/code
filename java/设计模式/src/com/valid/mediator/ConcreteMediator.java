package com.valid.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator{
    // 管理同事对象
    private final Map<String, Colleague> colleagueMap;
    private final Map<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String name, Colleague colleague) {
        colleagueMap.put(name, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", name);
        }
    }

    @Override
    public void getMessage(int stateChange, String name) {

    }

    @Override
    public void sendMessage() {

    }
}
