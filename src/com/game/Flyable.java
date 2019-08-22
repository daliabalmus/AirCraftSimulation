package com.game;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherProvider weatherProvider);
}
