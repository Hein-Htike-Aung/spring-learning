package com.example.jointableinheritance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("IN")
public class InHouse_Vet extends Vet {

    private double salary;

    public InHouse_Vet() {
    }

    public InHouse_Vet(String name, String qualification, double salary) {
        super(name, qualification);
        this.salary = salary;
    }
}
