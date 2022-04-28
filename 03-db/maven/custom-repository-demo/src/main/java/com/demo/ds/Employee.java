package com.demo.ds;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

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
    private String email;
    private String phone;
    private Date hiredate;
    private float salary;

    public Employee() {

    }
}
