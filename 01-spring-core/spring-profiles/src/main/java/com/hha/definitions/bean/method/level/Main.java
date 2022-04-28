package com.hha.definitions.bean.method.level;

import com.hha.definitions.bean.method.level.services.FinancialReportService;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file");
//        context.getEnvironment().setActiveProfiles("database");
        context.register(AppConfig.class);
        context.refresh();

        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);
        financialReportService.generateReport();
    }
}
