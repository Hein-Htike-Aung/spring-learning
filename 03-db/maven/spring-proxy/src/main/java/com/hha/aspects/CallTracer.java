package com.hha.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {

    @Pointcut("within(com.hha.service.*)")
    public void callTraceComponentsPointCut() {
    }

    @Around("callTraceComponentsPointCut()")
    public Object traceCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object returnObject = null;

        String methodName = proceedingJoinPoint.getSignature().getName();

        try {

            System.out.println("\nStarting " + methodName);

            returnObject = proceedingJoinPoint.proceed();

        } catch (Throwable throwable) {

            System.out.println(String.format("Exception has thrown from %s: %s", methodName, throwable.getMessage()));
        }

        System.out.println("Complete  " + methodName + "\n");

        return returnObject;

    }
}
