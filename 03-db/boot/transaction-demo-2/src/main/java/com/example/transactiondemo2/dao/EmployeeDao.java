package com.example.transactiondemo2.dao;

import com.example.transactiondemo2.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findAllEmployees() {

        return jdbcTemplate.query(
                "select * from employee",
                this::employeeMap
        );
    }

    public void deleteAllEmployee() {

        int numberOfDeletedRow = jdbcTemplate.update(
                "delete from employee"
        );

        System.out.println(String.format("Number of Deleted Employee = [%d]", numberOfDeletedRow));
    }

    public void saveEmployee(Employee employee) {

        if (employee.getEmployee_id() < 0) {
            throw new IllegalArgumentException("Employee_id must no be below 1");
        }

        int numberOfInsertedRow = jdbcTemplate.update(
                "insert into employee(employee_id, first_name, last_name, email, phone, hire_date, salary)" +
                        "values (?,?,?,?,?,?,?)",
                employee.getEmployee_id(),
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHire_date(),
                employee.getSalary()

        );

        if (numberOfInsertedRow == 1) {
            System.out.println(String.format("Saved Employee [%d]", employee.getEmployee_id()));
        } else {
            throw new IllegalArgumentException(String.format("Fail to Save Employee [%d]", employee.getEmployee_id()));
        }
    }


    @SneakyThrows
    private Employee employeeMap(ResultSet resultSet, int rowNo) {

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
