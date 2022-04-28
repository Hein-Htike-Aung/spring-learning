package com.example.transactiondemo.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Date hire_date;
    private float salary;

    public Employee() {
    }
}
