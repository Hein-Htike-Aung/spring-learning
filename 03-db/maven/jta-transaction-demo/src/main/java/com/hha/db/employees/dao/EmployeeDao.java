package com.hha.db.employees.dao;


import com.hha.db.employees.ds.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
