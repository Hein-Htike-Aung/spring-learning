package com.demo.service;


import com.demo.dao.custom.CustomEmployeeDao;
import com.demo.dao.custom.CustomEmployeeFindRepository;
import com.demo.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CustomEmployeeDao customEmployeeDao;

    public void queryEmployee() {


        System.out.println("\nfindByNameAndPhone");
        System.out.println(employeeDao.findByNameAndPhone("xiaoting", "55-555-55"));
        System.out.println(employeeDao.findEmpByNameAndPhone("Karina", "555-55-56"));
        System.out.println(customEmployeeDao.findByNameAndPhone("Winter", "555-55-58"));

        System.out.println("\nfindTop3ByOrderBySalaryDesc");
        employeeDao.findTop3ByOrderBySalaryDesc().forEach(System.out::println);

        System.out.println("\nfindByOrderByHire_dateDesc");
        employeeDao.findByOrderByHiredateDesc().forEach(System.out::println);

        System.out.println("\nfindByHire_dateBetween");
        employeeDao.findByHiredateBetween(Date.valueOf("2020-07-01"), Date.valueOf("2020-07-30")).forEach(System.out::println);

    }

}
