package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringBean01 {


//    ${} -> read only
//    #{} -> can modify (SPel Expression)

    @Value("#{'Wall Street'.toUpperCase()}")
    private String streetName;

    @Value("#{500 * 2}")
    private float accountBalance;

    @Value("#{'${app.department.id}'.toUpperCase()}")
    private String departmentName;

    @Value("#{${app.cases.map}}")
    private Map<String, Integer> casesMap;


    @Value("#{springBean02.taxId}")
    private int taxId;

    @Value("#{springBean02.taxValue}")
    private float taxValue;

    public String getStreetName() {
        return streetName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Map<String, Integer> getCasesMap() {
        return casesMap;
    }

    public int getTaxId() {
        return taxId;
    }

    public float getTaxValue() {
        return taxValue;
    }
}
