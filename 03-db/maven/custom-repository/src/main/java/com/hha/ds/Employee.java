package com.hha.ds;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Employee {
    @Id
    private int id;
    private String name;
    private String phone;
    private String email;
    private Date hire_date;
    private int salary;

    public Employee(){

    }
}
