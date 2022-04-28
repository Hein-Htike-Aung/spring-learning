package com.hha.definitions.custom.annotation.writer;

import com.hha.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.hha.definitions.custom.annotation.ds.FinancialQuarterSummary;
import com.hha.definitions.custom.annotation.ds.FinancialYearSummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
