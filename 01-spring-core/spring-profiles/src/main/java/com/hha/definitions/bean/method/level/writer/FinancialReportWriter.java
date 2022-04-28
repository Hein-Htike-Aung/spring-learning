package com.hha.definitions.bean.method.level.writer;

import com.hha.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.hha.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.hha.definitions.bean.method.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {

    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
