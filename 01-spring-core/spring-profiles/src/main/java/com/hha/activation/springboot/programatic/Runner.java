package com.hha.activation.springboot.programatic;

import com.hha.activation.springboot.programatic.dao.FinancialDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private FinancialDataDao financialDataDao;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Runner.class)
                .profiles("database").run(args);
//              .profiles("file").run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
