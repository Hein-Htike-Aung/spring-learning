package com.hha.activation.programmatic;

import com.hha.activation.programmatic.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file");
//        context.getEnvironment().setActiveProfiles("database");
        context.register(AppConfig.class);
        context.refresh();

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);
        System.out.println(financialDataDao.getClass().getSimpleName());

    }
}
