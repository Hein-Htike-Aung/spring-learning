package com.hha.definitions.configuration.level;

import com.hha.definitions.configuration.level.dao.FinancialDataDao;
import com.hha.definitions.configuration.level.services.FinancialReportService;
import com.hha.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseAppConfig.class, FileAppConfig.class})
public class AppConfig {

    @Bean
    public FinancialReportService financialReportService(
            FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter){
        return new FinancialReportService(financialReportWriter, financialDataDao);
    }
}
