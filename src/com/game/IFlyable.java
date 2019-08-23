package com.game;

public interface IFlyable {
    void updateConditions();
    void registerTower(WeatherProvider weatherProvider);
}
