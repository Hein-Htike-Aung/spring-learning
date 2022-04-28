package com.example.webui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {

    private int id;

    private String customerName;

    public Customer() {
    }
}
