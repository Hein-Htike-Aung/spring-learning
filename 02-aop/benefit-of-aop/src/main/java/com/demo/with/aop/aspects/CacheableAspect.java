package com.demo.with.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheableAspect {


    @Before("@annotation(com.demo.with.aop.annotations.Cacheable))")
    public void cacheSomething(JoinPoint joinPoint) throws Throwable {

        System.out.println(joinPoint.getSignature() + "is invoked.");

    }

}
