package com.example.rolesbasedspringmvcsecurity.dao;

import com.example.rolesbasedspringmvcsecurity.ds.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentsDao extends CrudRepository<Department,Integer> {
}
