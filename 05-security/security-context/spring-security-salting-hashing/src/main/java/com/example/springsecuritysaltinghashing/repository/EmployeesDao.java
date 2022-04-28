package com.example.springsecuritysaltinghashing.repository;

import com.example.springsecuritysaltinghashing.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesDao extends CrudRepository<Employee,Integer> {
}
