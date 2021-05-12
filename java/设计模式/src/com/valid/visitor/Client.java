package com.valid.visitor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("观察者模式")
    public void test() {
       ObjectStructure objectStructure = new ObjectStructure();

       objectStructure.attach(new Man());
       objectStructure.attach(new Woman());

       Success success = new Success();
       objectStructure.display(success);
    }
}
