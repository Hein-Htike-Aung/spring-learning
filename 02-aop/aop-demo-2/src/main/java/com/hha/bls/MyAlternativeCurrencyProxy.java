package com.hha.bls;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// LIke CGLIB Proxy
public class MyAlternativeCurrencyProxy extends AlternativeCurrencyRepository{

    private final AlternativeCurrencyRepository alternativeCurrencyRepository;

    public MyAlternativeCurrencyProxy(AlternativeCurrencyRepository alternativeCurrencyRepository) {
        this.alternativeCurrencyRepository = alternativeCurrencyRepository;
    }

    @Override
    public int getCurrencyCount() {

        System.out.println("CGLIB proxy");
        System.out.println("Before Method invoking");

        try{

            return super.getCurrencyCount();
        }finally {
            System.out.println("After Method invoking");
        }
    }
}
