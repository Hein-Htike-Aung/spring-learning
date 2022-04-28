package com.example.jdbccallbackdemo.services;

import com.example.jdbccallbackdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printAllEmployees() {

        employeeDao.findEmployees().forEach(System.out::println);
    }

    public void printAverageSalary() {
        System.out.println("Average Salary = " + employeeDao.findAverageSalary());;
    }

    public void printAverageSalary2() {
        System.out.println("Average Salary = " + employeeDao.findAverageSalary2());;
    }

    public void printAverageSalary3() {
        System.out.println("Average Salary = " + employeeDao.findAverageSalaryModernImplementation());
    }

    public void printAverageSalary4() {
        System.out.println("Average Salary = " + employeeDao.findAverageSalarySqlLvl());
    }

    public void printEmployeeIdByEmail() {
        System.out.println("Employee_id = " + employeeDao.findEmployeeIdFromEmail("xiao@gmail.com"));

    }
}
