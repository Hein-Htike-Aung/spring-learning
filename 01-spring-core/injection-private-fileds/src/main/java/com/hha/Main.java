package com.hha;

import com.hha.services.ReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        ReportService reportService = context.getBean(ReportService.class);
        reportService.execute();
    }
}
