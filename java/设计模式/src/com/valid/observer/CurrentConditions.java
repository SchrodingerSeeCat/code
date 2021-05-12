package com.valid.observer;

public class CurrentConditions implements Observer{
    private double temperature;
    private double pressure;
    private double humidity;

    @Override
    public void update(double temperature, double pressure, double humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("温度: " + temperature);
        System.out.println("气压: " + pressure);
        System.out.println("湿度: " + humidity);
    }
}
