package com.game;

public class Baloon extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
//        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);


        WeatherTower weatherTower = new WeatherTower();
//        if (weather.equals(weatherTower.getWeather(this.coordinates))) {
//        if (weather.equals(WeatherProvider.)) {
//
//        }

        if (weather.equals("SUN")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pictures");
        } else if (weather.equals("RAIN")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon");
        } else if (weather.equals("FOG")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): I can't see anything!");
        } else if (weather.equals("SNOW")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
        } else {
            System.out.println("Baloon" + this.name + "(" + this.id + "): I can'' reach the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says:"+ this.getClass().getSimpleName() + this.name + "(" +  this.id + ") registered to the tower");
    };
}
