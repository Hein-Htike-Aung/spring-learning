package com.example.generatequery.dao;

import com.example.generatequery.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findEmployeeEmailById(int id) {

        return jdbcTemplate.queryForObject(
                "select email from employee where employee_id = ?",
                new Object[]{id}, String.class
        );
    }

    public List<String> findEmployeesName() {

        return jdbcTemplate.queryForList(
                "select CONCAT(first_name, last_name) from employee",
                String.class
        );
    }

    public Map<String, Object> findEmployeeByIdUsingQueryForMap(int id) {

        return jdbcTemplate.queryForMap(
                "select * from employee where employee_id = ?",
                id
        );
    }

    public Employee findEmployeeByIdUsingQueryForObject(int id) {

        return jdbcTemplate.queryForObject(
                "select * from employee where employee_id = ?",
                new Object[]{id},
//                this::employeeMap
                (a, b) -> this.employeeMap(a, b)
        );
    }

    public List<Employee> findAllEmployees() {

        // query method is generic
        return jdbcTemplate.query(
                "select * from employee",
                this::employeeMap
        );
    }

    @SneakyThrows
    public Employee employeeMap(ResultSet resultSet, int rowNo) {

        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")

        );
    }

}
