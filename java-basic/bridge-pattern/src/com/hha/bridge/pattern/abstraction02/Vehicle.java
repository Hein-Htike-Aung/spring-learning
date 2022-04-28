package com.hha.bridge.pattern.abstraction02;

import com.hha.bridge.pattern.abstraction01.Workshop;

public abstract class Vehicle {

    protected Workshop workshop;

    public Vehicle(Workshop workshop) {
        this.workshop = workshop;
    }

    public abstract void manufacture();
}
