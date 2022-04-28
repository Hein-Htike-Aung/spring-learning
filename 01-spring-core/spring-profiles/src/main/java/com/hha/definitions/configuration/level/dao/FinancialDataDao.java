package com.hha.definitions.configuration.level.dao;

import com.hha.definitions.configuration.level.ds.FinancialMonthSummary;
import com.hha.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.hha.definitions.configuration.level.ds.FinancialYearSummary;

public interface FinancialDataDao {

    FinancialYearSummary findFinancialYearSummary(int year);
    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);
}
