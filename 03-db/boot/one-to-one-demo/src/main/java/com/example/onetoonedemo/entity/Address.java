package com.example.onetoonedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String streetName;

    private String city;

    @OneToOne(mappedBy = "address") // mappedBy defines ownership (customer is owner)
    private Customer customer;

    public Address() {
    }
}
