package com.hha.definitions.configuration.level.services;

import com.hha.definitions.configuration.level.dao.FinancialDataDao;
import com.hha.definitions.configuration.level.ds.FinancialMonthSummary;
import com.hha.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.hha.definitions.configuration.level.ds.FinancialYearSummary;
import com.hha.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.stereotype.Component;

public class FinancialReportService {

    private final FinancialReportWriter financialReportWriter;

    private final FinancialDataDao financialDataDao;

    public FinancialReportService(FinancialReportWriter financialReportWriter, FinancialDataDao financialDataDao) {
        this.financialReportWriter = financialReportWriter;
        this.financialDataDao = financialDataDao;
    }

    public void generateReport() {

        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2021);
        FinancialMonthSummary financialMonthSummary = financialDataDao.findFinancialMonthSummary(2021, 4);
        FinancialQuarterSummary financialQuarterSummary = financialDataDao.findFinancialQuarterSummary(2021, 1);

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report.");
        financialReportWriter.appendFinancialMonthSummary(financialMonthSummary);
        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
        financialReportWriter.appendFinancialQuarterSummary(financialQuarterSummary);
    }
}
