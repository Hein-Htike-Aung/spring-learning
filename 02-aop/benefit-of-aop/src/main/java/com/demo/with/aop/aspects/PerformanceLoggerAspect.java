package com.demo.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceLoggerAspect {

    private Logger logger = Logger.getLogger("performance.logger");


    @Around("@annotation(com.demo.with.aop.annotations.PerformanceLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // Before Invoking the Method
        long startTime = System.currentTimeMillis();

        try {
            // Invoking the Method
            return proceedingJoinPoint.proceed();
        }finally {
            // After Invoking the Method
            long finishTime = System.currentTimeMillis();

            Duration duration = Duration.ofMillis(finishTime - startTime);

            logger.info(String.format("Duration of %s execution is %s",
                    proceedingJoinPoint.getSignature(), duration));

        }
    }
}
