package com.hha;

import com.hha.command.BuyStock;
import com.hha.command.SellStock;

public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();

        BuyStock buyStock = new BuyStock(stock);
        BuyStock buyStock2 = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.takeOrder(buyStock2);
        broker.removeOrder(buyStock2);

        broker.placeOrder();

    }
}
