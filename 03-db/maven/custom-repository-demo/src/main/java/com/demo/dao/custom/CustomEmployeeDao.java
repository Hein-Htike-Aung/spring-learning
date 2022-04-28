package com.demo.dao.custom;

import com.demo.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomEmployeeDao extends JpaRepository<Employee, Integer>, CustomEmployeeFindRepository {
}
