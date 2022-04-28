package com.hha.definitions.configuration.level.writer;

import com.hha.definitions.configuration.level.ds.FinancialMonthSummary;
import com.hha.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.hha.definitions.configuration.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
