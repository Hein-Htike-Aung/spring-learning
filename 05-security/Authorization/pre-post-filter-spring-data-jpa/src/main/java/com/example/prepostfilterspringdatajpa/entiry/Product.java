package com.example.prepostfilterspringdatajpa.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String owner;

    public Product() {
    }
}
