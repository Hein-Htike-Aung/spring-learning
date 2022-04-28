package com.hha.definitions.component.level.dao;

import com.hha.definitions.component.level.ds.FinancialMonthSummary;
import com.hha.definitions.component.level.ds.FinancialQuarterSummary;
import com.hha.definitions.component.level.ds.FinancialYearSummary;

public interface FinancialDataDao {

    FinancialYearSummary findFinancialYearSummary(int year);
    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);
}
