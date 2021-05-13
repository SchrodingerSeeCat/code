package com.valid.memento.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("备忘录模式")
    public void test() {
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);
        System.out.println("===改变前状态===");
        gameRole.display();

        // 保存状态
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        // 修改状态
        gameRole.setVit(10);
        gameRole.setDef(10);
        System.out.println("===改变状态===");
        gameRole.display();

        // 恢复状态
        gameRole.recover(caretaker.getMemento());
        System.out.println("===恢复后的状态===");
        gameRole.display();
    }
}
