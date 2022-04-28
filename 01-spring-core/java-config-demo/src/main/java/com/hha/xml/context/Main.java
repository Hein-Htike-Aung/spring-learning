package com.hha.xml.context;


import com.hha.xml.context.beans.SpringBeans01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        context.registerShutdownHook();

        SpringBeans01 springBeans01 = context.getBean(SpringBeans01.class);
        springBeans01.printDependencies();
    }
}
