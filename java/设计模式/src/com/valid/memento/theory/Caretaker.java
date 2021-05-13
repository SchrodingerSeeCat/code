package com.valid.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> mementos = new ArrayList<>();
    public void add (Memento memento) {
        mementos.add(memento);
    }

    // 获取备忘录对象
    public Memento get(int index) {
        return mementos.get(index);
    }
}
