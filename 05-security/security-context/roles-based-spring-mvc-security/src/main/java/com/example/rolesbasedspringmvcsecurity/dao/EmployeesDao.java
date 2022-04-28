package com.example.rolesbasedspringmvcsecurity.dao;

import com.example.rolesbasedspringmvcsecurity.ds.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesDao extends CrudRepository<Employee,Integer> {
}
