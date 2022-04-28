package com.hha.bls;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// LIke JDK Proxy
public class MyCurrencyProxy implements CurrencyRepository{

    private final CurrencyRepository currencyRepository;

    public MyCurrencyProxy(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public int getCurrencyCount() {
        System.out.println("JDK Proxy");
        System.out.println("Before Invoking Method");

        try{

            return 0;
        }finally {
            System.out.println("After Invoking Method\n");
        }
    }


}
