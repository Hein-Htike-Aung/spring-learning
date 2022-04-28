package com.hha.bridge.pattern.abstraction02;

import com.hha.bridge.pattern.abstraction01.Workshop;

public class Bike extends Vehicle{

    public Bike(Workshop workshop) {
        super(workshop);
    }

    @Override
    public void manufacture() {
        System.out.println("Bike Manufacturing");
        workshop.work();
    }
}
