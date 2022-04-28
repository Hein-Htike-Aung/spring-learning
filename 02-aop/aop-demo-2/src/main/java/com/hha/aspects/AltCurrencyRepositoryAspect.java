package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
// Cglib Aop Proxy - No interface (CglibAopProxy class will extend the Concrete Class)
public class AltCurrencyRepositoryAspect {

    // Concrete Class Only (No Interface)
    @Before("this(com.hha.bls.AlternativeCurrencyRepository)")
    public void beforeThisCurrencyRepository() {

        System.out.println("Before -> @This (AlternativeCurrencyRepository)");
    }

    // Concrete Class Only (No Interface)
    @Before("target(com.hha.bls.AlternativeCurrencyRepository)")
    public void beforeTargetCurrencyRepository() {

        System.out.println("Before -> @Target (AlternativeCurrencyRepository)");
    }

}
