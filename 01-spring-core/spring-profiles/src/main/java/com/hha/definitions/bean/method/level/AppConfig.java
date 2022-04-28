package com.hha.definitions.bean.method.level;

import com.hha.definitions.bean.method.level.dao.DatabaseStoreFinancialDataDao;
import com.hha.definitions.bean.method.level.dao.FileStoreFinancialDataDao;
import com.hha.definitions.bean.method.level.dao.FinancialDataDao;
import com.hha.definitions.bean.method.level.services.FinancialReportService;
import com.hha.definitions.bean.method.level.writer.DatabaseStoreFinancialReportWriter;
import com.hha.definitions.bean.method.level.writer.FileStoreFinancialReportWriter;
import com.hha.definitions.bean.method.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@ComponentScan
@Configuration
public class AppConfig {

    @Bean
    public FinancialReportService financialReportService(FinancialReportWriter financialReportWriter, FinancialDataDao financialDataDao) {
        return new FinancialReportService(financialReportWriter, financialDataDao);
    }

    @Bean
    @Profile("database")
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    @Profile("database")
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }

    @Bean
    @Profile("file")
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    @Profile("file")
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }

}
