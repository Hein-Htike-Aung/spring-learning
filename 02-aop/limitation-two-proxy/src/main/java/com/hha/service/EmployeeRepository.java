package com.hha.service;

import com.hha.ds.Employee;

public interface EmployeeRepository {

    Employee findEmployeeId(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void findAndUpdateEmployeeById(long id, Employee employee);
}
