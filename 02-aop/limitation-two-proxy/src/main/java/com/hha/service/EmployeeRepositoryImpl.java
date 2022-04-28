package com.hha.service;

import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee findEmployeeId(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employee = findEmployeeId(id);

        // proxy doesn't work with self invocation method
        saveEmployee(employee);
    }

    // can't execute(only implement methods will be proxied)
    public void deleteEmployeeByEmail(String email) {

    }
}
