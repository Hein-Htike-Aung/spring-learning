package com.hha.definitions.bean.method.level.writer;

import com.hha.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.hha.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.hha.definitions.bean.method.level.ds.FinancialYearSummary;

public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter{

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
