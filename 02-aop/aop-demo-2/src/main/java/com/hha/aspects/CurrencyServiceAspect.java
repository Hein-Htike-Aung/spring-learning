package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.nio.ReadOnlyBufferException;
import java.util.Arrays;

@Component
@Aspect
public class CurrencyServiceAspect {

    // Annotation Lvl
    @Pointcut("@annotation(com.hha.annotations.InTransaction)")
    public void transactionAnnotationPointCut() {
    }

    // Package Lvl
    @Pointcut("within(com.hha.bls.*)")
    public void blsPackagePointCut() {
    }

    // Class Lvl
    @Pointcut("@within(com.hha.annotations.Secured)")
    public void securedClassPointCut() {
    }

    // Methods Lvl
    @Pointcut("execution(* com.hha.bls.CurrencyService.getExchangeRate(..))")
    public void getExchangeRate() {
    }

    // Bean Lvl
    @Pointcut("bean(currencyService)")
    public void namedBeanPointCut() {
    }

    // Args Pointcut - Method Lvl (All the methods with this args has been observed)
    @Pointcut("args(String, String, int)")
    public void stringAndIntegerArgs() {
    }

    // Args Type Pointcut - Method Lvl
    @Pointcut("@args(com.hha.annotations.Validate)")
    public void argsTypePointCut() {
    }

    // Class and Interface with only one implementation class
    @Pointcut("target(com.hha.bls.CurrencyRepository)")
    public void targetPointCut() {
    }

    // class lvl
    @Pointcut("@target(com.hha.annotations.Secured)")
    public void atTargetPoint() {
    }

    // Mix two Pointcuts
    @Pointcut("blsPackagePointCut() && transactionAnnotationPointCut()")
    public void blsPackageAndInTransactionPointCut() {
    }

    //    @Before("transactionAnnotationPointCut()")
    public void beforeTransactionAnnotationAdvice(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("blsPackagePointCut()")
    public void beforeBlsPackageAdvice(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("securedClassPointCut()")
    public void beforeSecuredAdvice(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("getExchangeRate()")
    public void beforeExecution(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("namedBeanPointCut()")
    public void beforeBeanExecution(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("stringAndIntegerArgs()")
    public void beforeArgsPointCut(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

        @Before("argsTypePointCut()")
    public void beforeArgsType(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //        @Before("targetPointCut()")
    public void beforeTargetClass(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("atTargetPoint()")
    public void beforeAtTargetClass(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @Before("blsPackageAndInTransactionPointCut()")
    public void beforeMixPointCut(JoinPoint jointPoint) {

        Object[] objs = jointPoint.getArgs();

        System.out.println("Before -> transactionAnnotationPointCut");

        System.out.println(
                jointPoint.getSignature().getName() + " has invoked with parameters called " + Arrays.toString(objs)
        );
    }

    //    @AfterThrowing(value = "execution(* com.hha.bls.CurrencyService.getCurrencyName(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("Exception was threw in type of " + exception.getClass().getSimpleName());
    }

    //    @AfterReturning(value = "execution(* com.hha.bls.CurrencyService.getCurrencyName(..))", returning = "value")
    public void afterReturningAdvice(String value) {
        System.out.println(value);
    }


    //    @Around("securedClassPointCut()")
    public Object aroundSecuredAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println(proceedingJoinPoint.getSignature().getName() + " is going to invoke with parameters called " +
                Arrays.toString(args));

        try {
            return proceedingJoinPoint.proceed();
        } finally {

            System.out.println(proceedingJoinPoint.getSignature().getName() + " is invoked");
        }
    }

}
