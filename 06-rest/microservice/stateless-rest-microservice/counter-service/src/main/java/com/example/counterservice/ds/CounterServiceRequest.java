package com.example.counterservice.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterServiceRequest {

    private int number;

    private CounterServiceRequest(@JsonProperty("number") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
