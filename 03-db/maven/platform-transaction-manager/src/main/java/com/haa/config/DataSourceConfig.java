package com.haa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8")
                .addScript("schema.sql").build();
    }


    //   For Transaction
    @Bean // PlatformTransactionManager
    @Autowired // DataSource
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }

}
