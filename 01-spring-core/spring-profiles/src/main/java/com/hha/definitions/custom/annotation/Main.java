package com.hha.definitions.custom.annotation;

import com.hha.definitions.custom.annotation.services.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

//        context.getEnvironment().setActiveProfiles("database");
        context.getEnvironment().setActiveProfiles("file");
        context.register(AppConfig.class);
        context.refresh();


        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);
        financialReportService.generateReport();
    }
}
