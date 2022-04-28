package com.example.springsecuritysaltinghashing.repository;


import com.example.springsecuritysaltinghashing.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentsDao extends CrudRepository<Department,Integer> {
}
