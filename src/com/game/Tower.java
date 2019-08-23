package com.game;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    public List<IFlyable> observers = new ArrayList<IFlyable>();

    public void register(IFlyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.getClass().getName()
                + " registered to the tower");
    }

    public void unregister(IFlyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable.getClass().getName() + " unregistered from the tower");
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
