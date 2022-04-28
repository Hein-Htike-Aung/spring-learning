package com.hha.definitions.component.level.dao;

import com.hha.definitions.component.level.ds.FinancialMonthSummary;
import com.hha.definitions.component.level.ds.FinancialQuarterSummary;
import com.hha.definitions.component.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DatabaseStoreFinancialDataDao implements FinancialDataDao {

    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Database Dao => findFinancialYearSummary");
        return null;
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthSummary");
        return null;
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterSummary");
        return null;
    }
}
