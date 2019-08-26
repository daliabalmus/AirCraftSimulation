package com.game;

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
//        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            System.out.println("Helicopter" + this.name + "(" + this.id + "): This is hot");
            coordinates.setLongitude(coordinates.getLongitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")) {
            System.out.println("Helicopter" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon");
            coordinates.setLongitude(coordinates.getLongitude() + 5);
        } else if (weather.equals("FOG")) {
            System.out.println("Helicopter" + this.name + "(" + this.id + "): I can't see anything!");
            coordinates.setLongitude(coordinates.getLongitude() + 1);
        } else if (weather.equals("SNOW")) {
            System.out.println("Helicopter" + this.name + "(" + this.id + "): My rotor is going to freeze");
            coordinates.setHeight(coordinates.getHeight() -15);
        } else {
            System.out.println("Helicopter" + this.name + "(" + this.id + "): I can'' reach the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says:" + this.getClass().getSimpleName() + this.name + "(" + this.id + ") registered to the tower");
    }
}
