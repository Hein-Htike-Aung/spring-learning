package com.hha.bridge.pattern.abstraction01;

public class ProductionWorkshop implements Workshop{

    @Override
    public void work() {
        System.out.println("Production in workshop");
    }
}
