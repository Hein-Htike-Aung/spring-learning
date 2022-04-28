package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Pointcut("within(com.hha.service.*)")
    public void serviceRepository() {}

    @Pointcut("within(com.hha.*)")
    public void samePackage() {}

    @Before("serviceRepository()")
    public void before(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
    }

//    @Before("samePackage()")
    public void samePackage(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
    }

}
