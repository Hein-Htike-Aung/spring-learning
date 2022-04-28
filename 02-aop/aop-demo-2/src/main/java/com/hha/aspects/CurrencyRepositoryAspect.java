package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
// JDK dynamic AOP Proxy - with interface (JdkDynamicAopProxy class will implement the Interface)
public class CurrencyRepositoryAspect {

    // Only Interface
    @Before("this(com.hha.bls.CurrencyRepository)")
    public void beforeThisCurrencyRepository() {

        System.out.println("Before -> @This (CurrencyRepository)");
    }

    // For Interface and Implementation Class
    @Before("target(com.hha.bls.CurrencyRepositoryImpl)")
//    @Before("target(com.hha.bls.CurrencyRepository)")
    public void beforeTargetCurrencyRepository() {

        System.out.println("Before -> @Target (CurrencyRepositoryImpl)");
    }

}
