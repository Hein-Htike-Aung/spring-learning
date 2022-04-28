package com.hha.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Employee {

    @Id
    private int id;
    private String first_name;

    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private int salary;

    public Employee() {

    }
}
