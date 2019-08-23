package com.game;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
//        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherProvider weatherProvider) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
