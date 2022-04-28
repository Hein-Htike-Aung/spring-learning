package com.hha.service;

import com.hha.dao.custom.CustomEmployeeDao;
import com.hha.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CustomEmployeeDao customEmployeeDao;


    public void queryEmployee(){
        System.out.println("Searching for John William with simple implementation...");
        System.out.println(employeeDao.findByFirstNameAndLastName("xiaoting","010-3434-45454"));

        System.out.println("Searching for Mary Shelly with custom dao implementation...");
        System.out.println(customEmployeeDao.findByFirstNameAndLastName("Minjeong","010-3434-45454"));


    }

}
