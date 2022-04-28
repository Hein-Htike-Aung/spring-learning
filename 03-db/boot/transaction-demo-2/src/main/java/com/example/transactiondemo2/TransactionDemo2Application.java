package com.example.transactiondemo2;

import com.example.transactiondemo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionDemo2Application implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionDemo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        try{
//
//            employeeService.saveEmployeesWithoutTransaction();
//        }catch (Exception e){
//            System.out.println("Exception during saving employees " + e.getMessage());
//        }
//
//        employeeService.employeeList();
//        employeeService.deletingEmployee();

        try{

            employeeService.saveEmployeesWithTransaction();
            // Transaction will be rollback
        }catch (Exception e){
            System.out.println("Exception during saving employees " + e.getMessage());
        }

        employeeService.employeeList();
        employeeService.deletingEmployee();


    }
}
