package com.game;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomWeather = 0;
        if (coordinates.getHeight() > 0 && coordinates.getLatitude() > 0 && coordinates.getLongitude() > 0) {
            Random random = new Random();
            randomWeather = random.nextInt(weather.length);
        }
        return weather[randomWeather];
    }
}
