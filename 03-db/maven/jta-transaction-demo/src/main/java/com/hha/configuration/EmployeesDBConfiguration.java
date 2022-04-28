package com.hha.configuration;


import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jdbc.AtomikosNonXADataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.hha.db.employees.dao"},
        entityManagerFactoryRef = "employeesEntityManagerFactory"
)
public class EmployeesDBConfiguration {

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean employeesEntityManagerFactory(DataSource employeesDataSource) {

        // Entities Configuration
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJtaDataSource(employeesDataSource);
        em.setPackagesToScan("com.hha.db.employees.ds");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;

    }


    @Bean
    public DataSource employeesDataSource() throws SQLException {

        // Database Configuration
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/spring1");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("password");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);


        // Plugin Configuration
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("employeesDb");
        return atomikosDataSourceBean;


    }

}
