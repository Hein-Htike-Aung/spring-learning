package com.hha.dao.custom;

import com.hha.ds.Employee;

public interface CustomEmployeeFindRepository {

    Employee findByFirstNameAndLastName(String name, String phone);
}
