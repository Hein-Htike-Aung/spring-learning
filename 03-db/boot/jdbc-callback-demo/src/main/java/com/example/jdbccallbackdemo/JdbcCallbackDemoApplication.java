package com.example.jdbccallbackdemo;

import com.example.jdbccallbackdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcCallbackDemoApplication implements CommandLineRunner {


    private final EmployeeService employeeService;

    public JdbcCallbackDemoApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcCallbackDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        employeeService.printAllEmployees();

//        employeeService.printAverageSalary();
//
//        employeeService.printAverageSalary2();
//
//        employeeService.printAverageSalary3();
//
//        employeeService.printAverageSalary4();
//
        employeeService.printEmployeeIdByEmail();
    }
}
