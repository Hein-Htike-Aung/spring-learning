package com.hha.service;

import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class AlternateEmployeeRepository {

    public Employee findEmployeeId(long id) {
        return new Employee();
    }

    public final void saveEmployee(Employee employee) {

    }

    public final void deleteEmployee(Employee employee) {

    }

    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employee = findEmployeeId(id);

        // proxy doesn't work with self invocation method
        saveEmployee(employee);
    }
}
