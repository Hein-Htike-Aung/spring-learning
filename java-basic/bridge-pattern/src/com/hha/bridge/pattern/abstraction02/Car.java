package com.hha.bridge.pattern.abstraction02;

import com.hha.bridge.pattern.abstraction01.Workshop;

public class Car extends Vehicle{

    public Car(Workshop workshop) {
        super(workshop);
    }

    @Override
    public void manufacture() {
        System.out.println("car Manufacturing");
        workshop.work();
    }
}
