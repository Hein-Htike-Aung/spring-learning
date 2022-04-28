package com.hha.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect // Aspects will be only working in Java Runtime
public class HelloBeanAspect {

//    @Before(value = "execution(* com..HelloBean.formatData(..))")
    public void beforeHelloBean(JoinPoint joinPoint) {

        System.out.println("HelloBean Aspect -> Start\n");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());

        System.out.println("\nHelloBean Aspect -> Stop");
    }

//    @After(value = "execution(* com..HelloBean.formatData(..))")
    public void afterHelloBean(JoinPoint joinPoint) {

        System.out.println("\nHelloBean Aspect -> Start\n");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());

        System.out.println("\nHelloBean Aspect -> Stop");
    }

//    @AfterReturning(value = "execution(* com..HelloBean.formatData(..))", returning = "returnValue")
    public void afterReturningHelloBean(JoinPoint joinPoint, Object returnValue) {

        System.out.println("HelloBean Aspect -> Start\n");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("Return Value = " + returnValue);

        System.out.println("\nHelloBean Aspect -> Stop");
    }

    @AfterThrowing(value = "within(com.hha.beans.HelloBean)", throwing = "e")
    public void afterReturingHelloBean(JoinPoint joinPoint, Exception e) {

        System.out.println("HelloBean Aspect -> Start\n");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("Exception Message = " + e.getMessage());

        System.out.println("\nHelloBean Aspect -> Stop");
    }

}
