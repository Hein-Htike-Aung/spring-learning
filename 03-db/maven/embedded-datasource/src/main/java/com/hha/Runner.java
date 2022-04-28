package com.hha;

import com.hha.dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        context.getBean(EmployeeDao.class).findEmployeeEmails().forEach(System.out::println);
    }
}
