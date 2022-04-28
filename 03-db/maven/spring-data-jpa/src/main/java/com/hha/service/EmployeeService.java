package com.hha.service;

import com.hha.dao.EmployeeDao;
import com.hha.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveAllEmployees () {
        System.out.println("\n\nsaveAllEmployees");

        employeeDao.save(new Employee(1, "Xiao", "ting", "xiao@gmail.com", "010-3434-3434", Date.valueOf("2021-05-3"), 2300));

        employeeDao.save(new Employee(2, "Min", "jeong", "xiao@gmail.com", "010-3434-3434", Date.valueOf("2021-05-3"), 2300));

        employeeDao.save(new Employee(3, "ning", "ning", "xiao@gmail.com", "010-3434-3434", Date.valueOf("2021-05-3"), 2300));
    }

    public void employeeList() {
        System.out.println("\n\nemployeeList");

        employeeDao.findAll().forEach(System.out::println);
    }



}
