package com.demo.dao.regular;

import com.demo.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Employee findByNameAndPhone(String name, String phone);

    //    @Query("select e from Employee e where e.name = ?1 and e.phone = ?2")
    @Query("select e from Employee e where e.name = :name and e.phone = :phone")
    Employee findEmpByNameAndPhone(@Param("name") String name, @Param("phone") String phone);


    List<Employee> findTop3ByOrderBySalaryDesc();

    List<Employee> findByHiredateBetween(Date min, Date max);

    List<Employee> findByOrderByHiredateDesc();


}
