package com.example.transactiondemo.service;

import com.example.transactiondemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printEmployeeReport() {
        // On 3 Connections
        System.out.println("Employee Report Start");
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println("Employee Report End");
    }

    @Transactional
    public void printReportInTransaction() {
        // Only on 1 Connection
        System.out.println("Employee Report Start in Transaction");
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println(employeeDao.findEmployeeCount());
        System.out.println("Employee Report End in Transaction");
    }
}
