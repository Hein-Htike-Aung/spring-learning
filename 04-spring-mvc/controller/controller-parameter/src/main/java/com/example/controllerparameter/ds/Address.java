package com.example.controllerparameter.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String addressName;
    private String country;

    public Address() {

    }

    public Address(Person person, ShortAddress shortAddress, Country country) {

        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.addressName = shortAddress.getShortAddressName();
        this.country = country.getCountryName();
    }
}
