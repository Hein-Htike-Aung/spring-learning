package com.hha.component.scanning.context;

import com.hha.component.scanning.context.beans.SpringBeans01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.registerShutdownHook();

        SpringBeans01 springBeans01 = context.getBean(SpringBeans01.class);
        springBeans01.printDependencies();
    }
}
