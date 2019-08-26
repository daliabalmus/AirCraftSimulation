package com.game;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Simulation Started");

        WeatherTower weatherTower = new WeatherTower();
        Tower tower = new Tower();
        List<IFlyable> flyables = new ArrayList<IFlyable>();

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
        
        baloon.updateConditions();
        jetPlane.updateConditions();
        helicopter1.updateConditions();
        helicopter2.updateConditions();

    }
}
