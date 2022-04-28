package com.hha.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employee_tbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name", unique = true)
    private String name;

    @Column(nullable = false)
    private LocalDate hireDate;

    private String department;

    private double salary;

    public Employee() {
    }

    public Employee(String name, LocalDate hireDate, String department, double salary) {
        this.name = name;
        this.hireDate = hireDate;
        this.department = department;
        this.salary = salary;
    }

    @PrePersist
    public void prePersist() {
//        hireDate = LocalDate.now();
        System.out.println("PrePersist");
    }
}
