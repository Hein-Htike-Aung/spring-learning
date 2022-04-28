package com.hha;

import com.hha.service.EmployeeService;
import com.hha.service.ManualTransaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.SQLException;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

//        employeeService.transaction1And2();

//        employeeService.transaction1And2WithPrecedingTransaction();

//        context.getBean(ManualTransaction.class).manualTransaction();

        // Checked Exception will cause rollback
//        try {
//            employeeService.methodWithCheckedExceptionNoCausingRollBack();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // Unchecked Exception will cause rollback
        try {
            employeeService.methodWithUncheckedExceptionCausingRollBack();
        }  catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
