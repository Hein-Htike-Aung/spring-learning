package com.hha.definitions.configuration.level;

import com.hha.definitions.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.hha.definitions.configuration.level.dao.FileStoreFinancialDataDao;
import com.hha.definitions.configuration.level.dao.FinancialDataDao;
import com.hha.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.hha.definitions.configuration.level.writer.FileStoreFinancialReportWriter;
import com.hha.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileAppConfig {

    @Bean
    public FinancialDataDao fileStoreFinancialDataDao(){
        return new FileStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }
}
