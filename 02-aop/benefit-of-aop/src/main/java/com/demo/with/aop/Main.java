package com.demo.with.aop;


import com.demo.with.aop.action.ComplexReportAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        ComplexReportAction reportAction = context.getBean(ComplexReportAction.class);
        try {
            reportAction.preform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
