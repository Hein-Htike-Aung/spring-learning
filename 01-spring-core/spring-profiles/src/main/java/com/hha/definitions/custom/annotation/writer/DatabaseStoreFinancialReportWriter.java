package com.hha.definitions.custom.annotation.writer;

import com.hha.definitions.custom.annotation.annotation.DatabaseProfile;
import com.hha.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.hha.definitions.custom.annotation.ds.FinancialQuarterSummary;
import com.hha.definitions.custom.annotation.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
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
