package com.example.jdbctemplateboot.dao;

import com.example.jdbctemplateboot.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {

        return jdbcTemplate.query(
                "select * from employee", this::mapEmployee);
    }

    public Employee firstHireEmployee() {

        return jdbcTemplate.queryForObject(
                "select * from employee order by hire_date limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeWithHighestSalary() {

        return jdbcTemplate.queryForObject(
                "select * from employee order by salary DESC limit 1",
                this::mapEmployee
        );
    }

    public int findEmployeeCount() {

        return jdbcTemplate.queryForObject(
                "select COUNT(*) from employee",
                Integer.class
        );
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int rowNumber) { // int rowNumber must be included

        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")
        );
    }
}
