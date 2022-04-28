package com.example.mysqldemo.dao;

import com.example.mysqldemo.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select * from employee", this::mapEmployee
        );
    }

    public List<String> findEmployeesEmail() {
        return jdbcTemplate.queryForList(
                "select email from employee", String.class
        );
    }

    public Employee findEmployeeWithHighestSalary() {

        return jdbcTemplate.queryForObject(
                "select * from employee order by salary DESC limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeId(Integer id) {

        return jdbcTemplate.queryForObject(
                "select * from employee where employee_id = ?",
                new Object[]{id},
                this::mapEmployee
        );
    }

    public Map<String, Object> findNewestEmployeeByHireDate() {
        // key -> Column Name Value -> Value
        return jdbcTemplate.queryForMap(
                "select * from employee order by hire_date desc limit 1"
        );
    }

    public SqlRowSet findEmployeesEmailAndPhone() {

        return jdbcTemplate.queryForRowSet(
                "select email, phone from employee"
        );
    }

    public void insertNewDummyRecord(Employee employee) {

        jdbcTemplate.update(
                "insert into employee values(?, ?, ?, ?, ?, ?, ?)",
                new Object[]{
                        employee.getEmployee_id(),
                        employee.getFirst_name(),
                        employee.getLast_name(),
                        employee.getEmail(),
                        employee.getPhone(),
                        employee.getHire_date(),
                        employee.getSalary()
                }
        );
    }

    public int updateDummyRecord(Integer id, String firstName) {
        return jdbcTemplate.update(
                "update employee set first_name = ? where employee_id = ?",
                new Object[]{firstName, id}
        );
    }

    public int[] updateRecordsWithDummyData() {

        return jdbcTemplate.batchUpdate(
                "update employee set first_name = 'aaa' where employee_id = 1",
                "update employee set first_name = 'bbb' where employee_id = 2",
                "update employee set first_name = 'ccc' where employee_id = 3"
                );
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int rowNumber) {

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
