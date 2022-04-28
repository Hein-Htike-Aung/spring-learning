package com.example.mysqldemo;

import com.example.mysqldemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(MysqlDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeService.printReport();
    }
}
