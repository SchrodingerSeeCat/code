package com.valid.memento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("备忘录模式")
    public void test() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("状态1");
        caretaker.add(originator.saveState()); // 保存状态

        originator.setState("状态2");
        caretaker.add(originator.saveState()); // 保存状态

        originator.setState("状态3");
        caretaker.add(originator.saveState()); // 保存状态

        System.out.println("当前状态: " + originator.getState());

        // 恢复状态1
        originator.refreshState(caretaker.get(0));
        System.out.println("恢复状态: " + originator.getState());
    }
}
