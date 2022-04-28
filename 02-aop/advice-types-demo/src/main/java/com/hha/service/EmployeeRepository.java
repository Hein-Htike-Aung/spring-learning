package com.hha.service;

import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {

    public Employee findEmployeeId(long id) {
        if(id < 0){
            throw new IllegalArgumentException("id must be greater than 0");
        }
        return new Employee(id);
    }

    public void saveEmployee(Employee employee) {}

    public void deleteEmployee(Employee employee) {}

    public String sayHello(String name) {
        return "Hello !" + name;
    }
}
