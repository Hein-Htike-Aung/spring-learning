package com.hha.dao.regular;


import com.hha.ds.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    Employee findByFirstNameAndLastName(String firstName,String lastName);

    @Query("select e from Employee e where e.name = ?1 and e.phone = ?2")
    Employee findEmpByFirstNameAndLastName( String name, String phone);

}
