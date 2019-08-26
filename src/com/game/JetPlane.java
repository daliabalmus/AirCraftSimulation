package com.game;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
//        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            System.out.println("JetPlane" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pictures");
            coordinates.setLatitude(coordinates.getLatitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")) {
            System.out.println("JetPlane" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
            coordinates.setLatitude(coordinates.getLatitude() + 5);
        } else if (weather.equals("FOG")) {
            System.out.println("JetPlane" + this.name + "(" + this.id + "): I can't see anything!");
            coordinates.setLatitude(coordinates.getLatitude() + 1);
        } else if (weather.equals("SNOW")) {
            System.out.println("JetPlane" + this.name + "(" + this.id + "): OMG! Winter is coming!");
            coordinates.setHeight(coordinates.getHeight() - 12);
        } else {
            System.out.println("JetPlane" + this.name + "(" + this.id + "): I can'' reach the weather tower.");
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
        System.out.println("Tower says:" + this.getClass().getSimpleName() + this.name + "(" + this.id + ") registered to the tower");
    }
}
