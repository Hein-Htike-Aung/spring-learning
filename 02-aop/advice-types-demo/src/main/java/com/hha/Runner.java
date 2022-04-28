package com.hha;

import com.hha.ds.Employee;
import com.hha.service.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        employeeRepository.findEmployeeId(3);

        try{
            employeeRepository.findEmployeeId(-4);
        }catch (Exception e) {

        }

        employeeRepository.sayHello("Xiaoting");

    }
}
