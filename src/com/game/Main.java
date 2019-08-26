package com.game;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Simulation Started");

        WeatherTower weatherTower = new WeatherTower();

        IFlyable baloon = AircraftFactory.newAirCraft("Baloon", "#B1", 0, 0, 0);
        IFlyable jetPlane = AircraftFactory.newAirCraft("JetPlane", "#J1", 0, 0, 0);
        IFlyable helicopter1 = AircraftFactory.newAirCraft("Helicopter", "#H1", 0, 0, 0);
        IFlyable helicopter2 = AircraftFactory.newAirCraft("Helicopter", "#H4", 0, 0, 0);

        assert baloon != null;
        baloon.registerTower(weatherTower);
        assert jetPlane != null;
        jetPlane.registerTower(weatherTower);
        assert helicopter1 != null;
        helicopter1.registerTower(weatherTower);
        assert helicopter2 != null;
        helicopter2.registerTower(weatherTower);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of simulations");
        int simulations = scanner.nextInt();

        System.out.println();

        System.out.println("Ready for landing");

        int delay = 500;
        int interval = 1000;  // iterate every sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int counter = 0;
            public void run() {
                counter++;
                System.out.println();
                System.out.println("Simulation " + counter);
                weatherTower.changeWeather();
                 if (counter > simulations) {
                     timer.cancel();
                     System.out.println();
                     System.out.println("Simulation completed. Aircrafts arrived to their destination");
                 }
            }
        }, delay, interval);

    }
}
