package com.hha.bls;

import com.hha.annotations.InTransaction;
import com.hha.annotations.Secured;
import com.hha.annotations.Validate;
import com.hha.ds.CurrencyId;
import org.springframework.stereotype.Component;

@Component
//@Secured
public class CurrencyService {

//    @InTransaction
    public float getExchangeRate(String from, String to) {

        return 0F;
    }

//    @InTransaction
    public float getExchangeRate(String from, String to, int multiplier) {
        return 0F;
    }

//    @InTransaction
    public String getCurrencyLongName(@Validate CurrencyId currencyId) {

        return null;
    }

//    @InTransaction
    public String getCurrencyName(CurrencyId currencyId) {

        if (currencyId == CurrencyId.USD) {
            return "USA";
        } else {
            throw new IllegalArgumentException("test");
        }
    }
}
