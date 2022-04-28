package com.example.jointableinheritance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Inheritance
@DiscriminatorValue("EX")
public class External_Vet extends Vet {

    private String country;

    private double visiting_fee;

    public External_Vet() {

    }

    public External_Vet(String name, String qualification, String country, double visiting_fee) {
        super(name, qualification);
        this.country = country;
        this.visiting_fee = visiting_fee;
    }
}
