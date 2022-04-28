package com.haa;

import com.haa.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

//        try{
//
//            employeeService.saveEmployeesWithoutTransaction();
//
//        }catch (Exception e) {
//            System.out.println("Exception = " + e.getMessage());
//        }
//
//        employeeService.employeeList();
//        employeeService.deletingEmployee();

        try{

            employeeService.saveEmployeesWithTransaction();

        }catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
        }

        employeeService.employeeList();
        employeeService.deletingEmployee();

    }
}
