package com.hha.activation.springboot.property;

import com.hha.activation.springboot.property.dao.FinancialDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private FinancialDataDao financialDataDao;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);

        // resources -> application.properties
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
