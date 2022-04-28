package com.demo.dao.custom;

import com.demo.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomEmployeeFindRepository {

    Employee findByNameAndPhone(String name, String phone);
}
