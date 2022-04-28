package com.example.jdbctemplateboot.services;

import com.example.jdbctemplateboot.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReport {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void printReport() {


        System.out.println("Employee Count = " + employeeRepository.findEmployeeCount());

        System.out.println("First hire Employee = " + employeeRepository.firstHireEmployee());

        System.out.println("Highest Salary Employee = " + employeeRepository.findEmployeeWithHighestSalary());

        System.out.println("Employee List=======================");

        employeeRepository.findEmployees().forEach(System.out::println);
    }
}
