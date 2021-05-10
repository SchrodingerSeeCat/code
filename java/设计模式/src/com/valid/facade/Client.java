package com.valid.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("外观模式")
    public void test() {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        System.out.println("=====================");
        homeTheaterFacade.play();
        System.out.println("=====================");
        homeTheaterFacade.pause();
        System.out.println("=====================");
        homeTheaterFacade.end();
    }
}
