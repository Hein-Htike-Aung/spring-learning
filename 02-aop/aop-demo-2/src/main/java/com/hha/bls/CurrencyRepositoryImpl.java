package com.hha.bls;

import com.hha.annotations.Secured;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRepositoryImpl implements CurrencyRepository{

    @Override
    public int getCurrencyCount() {
        return 0;
    }


}
