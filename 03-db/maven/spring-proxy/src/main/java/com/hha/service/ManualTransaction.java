package com.hha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ManualTransaction {

    @Autowired
    private DataSource dataSource;

    public void manualTransaction() throws SQLException {

        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        try{
            // database Operation


            connection.commit();

        }catch (SQLException sqlException){

            connection.rollback();
        }finally {
            connection.close();
        }
    }


}
