package com.example.jdbccallbackdemo.dao;

import com.example.jdbccallbackdemo.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {

        return jdbcTemplate.query(
                "select * from employee",

                // jdbc RowMapper callback // State Less
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Employee(
                                rs.getInt("employee_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("phone"),
                                rs.getDate("hire_date"),
                                rs.getFloat("salary")
                        );
                    }
                }
        );
    }

    public float findAverageSalary() {
        AverageSalaryRowCallbackHandler averageSalaryRowCallbackHandler = new AverageSalaryRowCallbackHandler();

        jdbcTemplate.query("select salary from employee",
                // jdbc RowCallbackHandler callback // State Full
                averageSalaryRowCallbackHandler);

        return averageSalaryRowCallbackHandler.averageSalary();
    }

    private static class AverageSalaryRowCallbackHandler implements RowCallbackHandler {

        private float salarySum = 0;
        private int salaryCount = 0;

        @Override
        public void processRow(ResultSet rs) throws SQLException {

            salarySum += rs.getFloat("salary");
            ++salaryCount;

        }

        public float averageSalary() {
            return salarySum / salaryCount;
        }

    }

    public float findAverageSalary2() {

        return jdbcTemplate.query(
                "select salary from employee",

                // jdbc ResultSetExtractor callback
                new AverageSalaryResultSetExtractor()
        );

    }

    private static class AverageSalaryResultSetExtractor implements ResultSetExtractor<Float> {

        @Override
        public Float extractData(ResultSet rs) throws SQLException, DataAccessException {

            float salarySum = 0;
            int salaryCount = 0;

            while (rs.next()) {
                salarySum += rs.getFloat("salary");
                salaryCount++;
            }

            return salarySum / (float) salaryCount;
        }
    }

    public double findAverageSalaryModernImplementation() {

        return jdbcTemplate.queryForList("select salary from employee", Double.class)
                .stream()

                // Change to Primitive Type
                .mapToDouble(Double::valueOf)

                .average()
                .orElse(0);
    }

    public double findAverageSalarySqlLvl() {

        return jdbcTemplate.queryForObject(
                "select AVG (salary) from employee",
                Double.class
        );
    }

    public int findEmployeeIdFromEmail(String email) {

        return jdbcTemplate.query(

                // Create Query
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("select employee_id from employee where email = ?");
                    }
                },

                // Set Value
                new PreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, email);
                    }
                },

                // Throw Exception
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

                        if (rs.next()) {
                            return rs.getInt("employee_id");
                        }

                        throw new SQLException("Unable to find id by email");
                    }
                }
        );
    }

}
