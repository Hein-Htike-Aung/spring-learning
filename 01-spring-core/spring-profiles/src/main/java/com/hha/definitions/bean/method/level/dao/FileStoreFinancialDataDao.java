package com.hha.definitions.bean.method.level.dao;

import com.hha.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.hha.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.hha.definitions.bean.method.level.ds.FinancialYearSummary;

public class FileStoreFinancialDataDao implements FinancialDataDao{

    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {

        System.out.println("FileDao => findFinancialYearSummary");
        return null;
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("FileDao => findFinancialMonthSummary");
        return null;
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("FileDao => findFinancialQuarterSummary");
        return null;
    }
}
