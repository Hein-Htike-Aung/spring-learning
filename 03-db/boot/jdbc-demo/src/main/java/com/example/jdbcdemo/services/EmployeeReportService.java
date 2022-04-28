package com.example.jdbcdemo.services;

import com.example.jdbcdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printEmployeeEmails() {

        System.out.println("Report Start...");

        employeeDao.firstEmployeeEmails()
                        .forEach(System.out::println);

        System.out.println("Report End...");
    }
}
