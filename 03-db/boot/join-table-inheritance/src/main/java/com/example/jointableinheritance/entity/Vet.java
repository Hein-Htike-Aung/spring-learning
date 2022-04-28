package com.example.jointableinheritance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // One table
@Inheritance(strategy = InheritanceType.JOINED) // Three table
@DiscriminatorColumn(name = "VET_TYPE")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // don't need @DiscriminatorColumn // need @GeneratedValue(strategy = GenerationType.AUTO)
public abstract class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String qualification;

    public Vet() {
    }

    public Vet(String name, String qualification) {
        this.name = name;
        this.qualification = qualification;
    }
}
