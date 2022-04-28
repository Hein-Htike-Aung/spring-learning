package com.hha.command;

import com.hha.Stock;

public class SellStock implements Order { // actual command processing

    // A request is wrapped under an object as command
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sellStock();
    }
}
