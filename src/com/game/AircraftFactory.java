package com.game;

public abstract class AircraftFactory {

    public static IFlyable newAirCraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        coordinates.setLongitude(longitude);
        coordinates.setLatitude(longitude);
        coordinates.setHeight(longitude);

        if (type.equals("Baloon")) {
            return new Baloon(name, coordinates);
        } else if (type.equals("Helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.equals("JetPlane")) {
            return new JetPlane(name, coordinates);
        } else {
            return null;
        }
    }

}
