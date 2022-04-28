package com.hha.definitions.bean.method.level.dao;

import com.hha.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.hha.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.hha.definitions.bean.method.level.ds.FinancialYearSummary;

public interface FinancialDataDao {

    FinancialYearSummary findFinancialYearSummary(int year);
    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);
}
