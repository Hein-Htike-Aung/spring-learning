package com.hha.services;

import com.hha.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printEmail() {
        employeeDao.findEmployeeEmails()
                .forEach(System.out::println);
    }
}
