package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Pointcut("within(com.hha.service.*)")
    public void serviceRepository() {}

    @Pointcut("execution(public String com.hha.service.EmployeeRepository.sayHello(*))")
    public void executionPointCut() {}

    @Before("serviceRepository()")
    public void before(JoinPoint joinPoint) {

        System.out.println("Before Pointcut========================");

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
    }

//    @After("serviceRepository()")
    public void after(JoinPoint joinPoint) {

        System.out.println("After Pointcut=======================");

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
    }

    // Only work with Exception throwing method
//    @AfterThrowing(value = "serviceRepository()", throwing = "e")
    public void after(JoinPoint joinPoint, Exception e) {

        System.out.println("AfterThrowing Pointcut====================");

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
        System.out.println(e.getMessage());
    }

    // Only work with method with Returning value
//    @AfterReturning(value = "serviceRepository()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {

        System.out.println("AfterThrowing Pointcut====================");

        Object[] args = joinPoint.getArgs();

        System.out.println(joinPoint.getSignature().getName()
                + " is invoked with parameters called " + Arrays.toString(args));
        System.out.println(returnValue);
    }

//    @Around("serviceRepository()")
//    @Around("executionPointCut())")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Before -> " + proceedingJoinPoint.getSignature());
        try{
            return proceedingJoinPoint.proceed();
        }finally {
            System.out.println("After -> " + proceedingJoinPoint.getSignature());
        }

    }

}
