package com.hha.dao.custom;


import com.hha.ds.Employee;
import org.springframework.data.repository.CrudRepository;


public interface CustomEmployeeDao extends CrudRepository<Employee,Integer> ,CustomEmployeeFindRepository{
}
