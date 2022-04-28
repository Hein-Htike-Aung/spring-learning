package com.hha.definitions.component.level.writer;

import com.hha.definitions.component.level.ds.FinancialMonthSummary;
import com.hha.definitions.component.level.ds.FinancialQuarterSummary;
import com.hha.definitions.component.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
