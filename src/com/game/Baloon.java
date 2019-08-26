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

        if (weather.equals("SUN")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pictures");
            coordinates.setLongitude(coordinates.getLongitude() + 2);
            coordinates.setHeight(coordinates.getHeight() + 4);

            System.out.println(coordinates.getHeight());
        } else if (weather.equals("RAIN")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon");
            coordinates.setHeight(coordinates.getHeight() - 5);

        } else if (weather.equals("FOG")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): I can't see anything!");
            coordinates.setHeight(coordinates.getHeight() - 3);
        } else if (weather.equals("SNOW")) {
            System.out.println("Baloon" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
            coordinates.setHeight(coordinates.getHeight() - 15);
        } else {
            System.out.println("Baloon" + this.name + "(" + this.id + "): I can't reach the weather tower.");
        }

        if (coordinates.getHeight() < 0) {
            weatherTower.unregister(this);
            System.out.println(this.getClass().getSimpleName() + this.name + "(" +  this.id + ") unregistered from the tower");
            System.out.println("Current coordinates (m) " + coordinates.getLongitude() +
                    " longitude, " + coordinates.getLatitude() +
                    " latitude, " + coordinates.getHeight() + " height");
        } else if (coordinates.getHeight() > 100) {
            coordinates.setHeight(100);
            System.out.println(this.getClass().getSimpleName() + this.name + "(" +  this.id + ") remained at the upper limit");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;

        weatherTower.register(this);
        System.out.println("Tower says:"+ this.getClass().getSimpleName() + this.name + "(" +  this.id + ") registered to the tower");

    };
}
