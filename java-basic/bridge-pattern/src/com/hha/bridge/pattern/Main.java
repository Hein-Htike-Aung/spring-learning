package com.hha.bridge.pattern;

import com.hha.bridge.pattern.abstraction01.AssembleWorkShop;
import com.hha.bridge.pattern.abstraction01.ProductionWorkshop;
import com.hha.bridge.pattern.abstraction02.Bike;
import com.hha.bridge.pattern.abstraction02.Vehicle;

public class Main {

    public static void main(String[] args) {

        Vehicle vehicle01 = new Bike(new AssembleWorkShop());
        vehicle01.manufacture();

        vehicle01 = new Bike(new ProductionWorkshop());
        vehicle01.manufacture();
    }
}
