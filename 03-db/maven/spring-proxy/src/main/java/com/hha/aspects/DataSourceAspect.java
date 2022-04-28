package com.hha.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object aroundDataSource(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("DataSourceAspect : " + proceedingJoinPoint.getSignature());

        Object returnObject = proceedingJoinPoint.proceed();

        if (returnObject instanceof Connection) {

            return createConnectionProxy((Connection) returnObject);
        } else {
            return returnObject;
        }
    }

    private Object createConnectionProxy(Connection returnObject) {

        return Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(returnObject)
        );
    }
}
