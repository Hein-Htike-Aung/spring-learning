package com.hha;

import com.hha.command.Order;

import java.util.ArrayList;
import java.util.List;

public class Broker { // invoker object

    //  Invoker object looks for the appropriate object which can handle this command
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
        System.out.println("Order added");
    }

    public void removeOrder(Order order) {
        orderList.remove(order);
        System.out.println("Order removed");
    }

    public void placeOrder() {
        orderList.forEach(Order::execute);
    }
}
