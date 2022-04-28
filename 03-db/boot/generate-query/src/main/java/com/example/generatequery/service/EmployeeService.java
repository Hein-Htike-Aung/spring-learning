package com.example.generatequery.service;

import com.example.generatequery.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printEmployeeReport() {

        System.out.println("\n\nEmployee Report Start\n\n");

        System.out.println("\nfindEmployeeEmailById");
        System.out.println(employeeDao.findEmployeeEmailById(1));

        System.out.println("\nfindEmployeesName");
        employeeDao.findEmployeesName().forEach(System.out::println);

        System.out.println("\nfindEmployeeByIdUsingQueryForMap");
        System.out.println(employeeDao.findEmployeeByIdUsingQueryForMap(2).values());

        System.out.println("\nfindEmployeeByIdUsingQueryForObject");
        System.out.println(employeeDao.findEmployeeByIdUsingQueryForObject(3));

        System.out.println("\nfindAllEmployees");
        employeeDao.findAllEmployees().forEach(System.out::println);

        System.out.println("\n\nEmployee Report end\n\n");
    }
}
