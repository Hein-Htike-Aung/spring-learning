package com.example.jdbcdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        // dataSource -> username, password and URL
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> firstEmployeeEmails() {
        return jdbcTemplate.queryForList("select email from Employee", String.class);
    }
}
