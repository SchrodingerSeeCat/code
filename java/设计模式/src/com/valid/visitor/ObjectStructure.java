package com.valid.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {
    private final List<Person> persons = new LinkedList<>();

    // 添加
    public void attach(Person person) {
        persons.add(person);
    }

    // 移除
    public void detach(Person person) {
        persons.remove(person);
    }

    // 显示测评情况
    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }
}
