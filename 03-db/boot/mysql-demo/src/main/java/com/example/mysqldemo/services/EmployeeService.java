package com.example.mysqldemo.services;

import com.example.mysqldemo.dao.EmployeeDao;
import com.example.mysqldemo.ds.Employee;
import com.example.mysqldemo.util.SqlRowSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employees========");
        employeeDao.findEmployees().forEach(System.out::println);

        System.out.println("Employees Email==============");
        employeeDao.findEmployeesEmail().forEach(System.out::println);

        System.out.println("Highest Salary Employee=============");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());

        System.out.println("Newest Employee============");
        System.out.println(employeeDao.findNewestEmployeeByHireDate());

        System.out.println("Employee phone & Email===================");
        System.out.println(SqlRowSetUtil.sqlRowSetToString(employeeDao.findEmployeesEmailAndPhone()));

        System.out.println("Insert New Dummy Record================");
        Employee employee = new Employee();
        employee.setEmployee_id(999);
        employee.setFirst_name("dummy");
        employee.setLast_name("dummy");
        employee.setEmail("dummy@gmail.com");
        employee.setPhone("11111111111");
        employee.setHire_date(new Date(2021-2-2));
        employee.setSalary(343434);
        employeeDao.insertNewDummyRecord(employee);
        System.out.println(employeeDao.findEmployeeId(999));

        System.out.println("Update Dummy Record");
        System.out.println(employeeDao.updateDummyRecord(999, "UpdatedDummy"));
        System.out.println(employeeDao.findEmployeeId(999));

        System.out.println("Update");
        employeeDao.updateRecordsWithDummyData();
        employeeDao.findEmployees().forEach(System.out::println);


    }
}
