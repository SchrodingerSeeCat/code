package com.valid.observer;

import java.util.LinkedList;
import java.util.List;

public class WeatherData implements Subject{
    private double temperature;
    private double pressure;
    private double humidity;

    private final List<Observer> observers;

    public WeatherData() {
        observers = new LinkedList<>();
    }

    public void setData(double temperature, double pressure, double humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer); // 注册
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer); // 注销
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) { // 更新
            observer.update(temperature, pressure, humidity);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }
}
