package com.hha.definitions.custom.annotation.dao;

import com.hha.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.hha.definitions.custom.annotation.ds.FinancialQuarterSummary;
import com.hha.definitions.custom.annotation.ds.FinancialYearSummary;

public interface FinancialDataDao {

    FinancialYearSummary findFinancialYearSummary(int year);
    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);
}
