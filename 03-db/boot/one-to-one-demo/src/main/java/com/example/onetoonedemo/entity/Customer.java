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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // Address will save/remove automatically
    private Address address;

    public Customer() {
    }
}
