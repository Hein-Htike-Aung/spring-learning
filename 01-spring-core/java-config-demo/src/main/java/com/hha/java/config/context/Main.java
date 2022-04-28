package com.hha.java.config.context;

import com.hha.java.config.context.beans.SpringBeans01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBeans01 springBeans01 = context.getBean(SpringBeans01.class);
        springBeans01.printDependencies();
    }
}
