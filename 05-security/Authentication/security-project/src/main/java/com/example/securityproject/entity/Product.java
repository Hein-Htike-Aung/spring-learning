package com.example.securityproject.entity;

import com.example.securityproject.entity.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Product() {
    }
}
