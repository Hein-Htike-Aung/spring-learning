package com.hha.definitions.configuration.level;

import com.hha.definitions.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.hha.definitions.configuration.level.dao.FinancialDataDao;
import com.hha.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.hha.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseAppConfig {

    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao(){
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }
}
