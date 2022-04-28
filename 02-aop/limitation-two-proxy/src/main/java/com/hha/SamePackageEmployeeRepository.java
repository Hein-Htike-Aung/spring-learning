package com.hha;

import com.hha.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class SamePackageEmployeeRepository {

    public void saveEmployee(Employee employee) {

    }

    protected void deleteEmployee(Employee employee) {

    }

    void deleteEmployeeByEmail(String email) {

    }

    private void deleteEmployeeByPhone(String phone) {
        System.out.println("deleteEmployeeByPhone");
    }

}
