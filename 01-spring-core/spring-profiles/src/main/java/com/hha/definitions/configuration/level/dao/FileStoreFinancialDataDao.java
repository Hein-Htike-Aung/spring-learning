package com.hha.definitions.configuration.level.dao;

import com.hha.definitions.configuration.level.ds.FinancialMonthSummary;
import com.hha.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.hha.definitions.configuration.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class FileStoreFinancialDataDao implements FinancialDataDao {

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
