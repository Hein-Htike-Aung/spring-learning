package com.hha.definitions.custom.annotation.dao;

import com.hha.definitions.custom.annotation.annotation.FileProfile;
import com.hha.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.hha.definitions.custom.annotation.ds.FinancialQuarterSummary;
import com.hha.definitions.custom.annotation.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@FileProfile
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
