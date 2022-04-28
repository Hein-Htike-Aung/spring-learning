package com.hha.db.employees.ds;


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
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private float salary;


    public Employee(){

    }
}
