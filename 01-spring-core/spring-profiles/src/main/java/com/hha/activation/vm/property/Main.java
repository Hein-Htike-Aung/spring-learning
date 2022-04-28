package com.hha.activation.vm.property;


import com.hha.activation.vm.AppConfig;
import com.hha.activation.vm.property.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        // VM Options
//        -Dspring.profiles.active=database
//        -Dspring.profiles.active=file

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
