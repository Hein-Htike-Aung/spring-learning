package com.hha.definitions.component.level.writer;

import com.hha.definitions.component.level.ds.FinancialMonthSummary;
import com.hha.definitions.component.level.ds.FinancialQuarterSummary;
import com.hha.definitions.component.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileStoreFinancialReportWriter implements FinancialReportWriter {

    @Override
    public void appendFreeText(String title) {
        System.out.println("File writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("File writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("File writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File writer => appendFinancialMonthSummary");
    }

}
