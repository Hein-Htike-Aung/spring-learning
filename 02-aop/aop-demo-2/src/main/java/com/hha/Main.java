package com.hha;

import com.hha.bls.*;
import com.hha.ds.CurrencyId;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

//        CurrencyRepository currencyRepository = context.getBean(CurrencyRepository.class);
//        currencyRepository.getCurrencyCount();
//
//        context.getBean(AlternativeCurrencyRepository.class).getCurrencyCount();

        CurrencyService currencyService = context.getBean(CurrencyService.class);

//        currencyService.getExchangeRate("EUR", "USD");
//        currencyService.getExchangeRate("EUR", "USE", 100);
        currencyService.getCurrencyName(CurrencyId.USD);



//        try{
//            currencyService.getCurrencyName(CurrencyId.EUR);
//        }catch (Exception e) {
//          //  e.printStackTrace();
//        }


    }
}
