package com.example.jdbcdemo;

import com.example.jdbcdemo.services.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeReportService employeeReportService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeReportService.printEmployeeEmails();
    }
}
