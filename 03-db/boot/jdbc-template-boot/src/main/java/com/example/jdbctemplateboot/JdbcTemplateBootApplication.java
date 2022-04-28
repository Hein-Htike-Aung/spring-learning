package com.example.jdbctemplateboot;

import com.example.jdbctemplateboot.services.EmployeeReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateBootApplication implements CommandLineRunner {

    @Autowired
    private EmployeeReport employeeReport;

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeReport.printReport();
    }
}
