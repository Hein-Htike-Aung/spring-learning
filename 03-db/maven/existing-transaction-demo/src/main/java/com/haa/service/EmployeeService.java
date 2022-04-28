package com.haa.service;


import com.haa.dao.EmployeeDao;
import com.haa.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void employeeList() {

        System.out.println("\n\nEmployee List");

        employeeDao.findAllEmployees().forEach(System.out::println);

    }

    public void deletingEmployee() {

        System.out.println("\n\nDeleting Employee");

        employeeDao.deleteAllEmployee();
    }

    public void saveEmployeesWithoutTransaction()  {
        System.out.println("\n\nSaving Employees without Transaction");

//        saveEmployees();

        employeeDao.saveEmployee(new Employee(
                1, "Xiao", "ting", "xiao@gmail.com", "01034343434", Date.valueOf("2021-06-13"), 3200
        ));
    }

    @Transactional
    public void saveEmployeesWithTransaction()  {
        System.out.println("\n\nSaving Employees with Transaction");

//        saveEmployees();
        employeeDao.saveEmployee(new Employee(
                2, "Xiao", "ting", "xiao@gmail.com", "01034343434", Date.valueOf("2021-06-13"), 3200
        ));
    }

    private void saveEmployees() {
        employeeDao.saveEmployee(new Employee(
                1, "Xiao", "ting", "xiao@gmail.com", "01034343434", Date.valueOf("2021-06-13"), 3200
        ));

//        employeeDao.saveEmployee(new Employee(
//                2, "So", "hee", "sohee@gmail.com", "01034343434", Date.valueOf("2021-07-14"), 1200
//        ));
//
//        employeeDao.saveEmployee(new Employee(
//                3, "Min", "jeong", "minjeong@gmail.com", "01034343434", Date.valueOf("2021-08-16"), 9200
//        ));
//
//        employeeDao.saveEmployee(new Employee(
//                -4, "Karina", "aespa", "karina@gmail.com", "01034343434", Date.valueOf("2021-11-1"), 4200
//        ));
//
//        employeeDao.saveEmployee(new Employee(
//                5, "Giselle", "aespa", "giselle@gmail.com", "01034343434", Date.valueOf("2021-11-1"), 9200
//        ));

    }
}
