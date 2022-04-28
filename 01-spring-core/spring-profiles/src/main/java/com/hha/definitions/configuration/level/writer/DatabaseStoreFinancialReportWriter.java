package com.hha.definitions.configuration.level.writer;

import com.hha.definitions.configuration.level.ds.FinancialMonthSummary;
import com.hha.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.hha.definitions.configuration.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {

    @Override
    public void appendFreeText(String title) {
        System.out.println("Database writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("Database writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("Database writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database writer => appendFinancialMonthSummary");
    }

}
