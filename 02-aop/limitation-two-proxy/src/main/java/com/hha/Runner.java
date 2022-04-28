package com.hha;

import com.hha.ds.Employee;
import com.hha.service.AlternateEmployeeRepository;
import com.hha.service.EmployeeRepository;
import com.hha.service.EmployeeRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.MarshalException;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        // final method, self invocation method and final class con not be proxied

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        AlternateEmployeeRepository alternateEmployeeRepository = context.getBean(AlternateEmployeeRepository.class);
        SamePackageEmployeeRepository samePackageEmployeeRepository = context.getBean(SamePackageEmployeeRepository.class);

        // JDK Proxy (work with interface, only public methods will be allowed)
        employeeRepository.findAndUpdateEmployeeById(5, new Employee());
        employeeRepository.findEmployeeId(5);
        employeeRepository.saveEmployee(new Employee());

        alternateEmployeeRepository.findAndUpdateEmployeeById(5, new Employee());
        alternateEmployeeRepository.findEmployeeId(4);
        alternateEmployeeRepository.saveEmployee(new Employee());
        alternateEmployeeRepository.deleteEmployee(new Employee());

        // CGLIB Proxy (work with class - public, protected, no modifier will be allowed)
        samePackageEmployeeRepository.saveEmployee(new Employee());
        samePackageEmployeeRepository.deleteEmployee(new Employee());
        samePackageEmployeeRepository.deleteEmployeeByEmail("xiao@gmail.com");

    }
}
