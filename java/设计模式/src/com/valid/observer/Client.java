package com.valid.observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("观察者模式")
    public void test() {
        // 创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        // 创建观察者
        CurrentConditions currentConditions = new CurrentConditions();

        // 这次到weatherData
        weatherData.register(currentConditions);

        weatherData.setData(10, 100, 30.3);
    }
}
