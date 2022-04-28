package com.example.transactiondemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object aroundDataSource(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("DataSourceAspect Data Source Trance: " + proceedingJoinPoint.getSignature());

        Object returnObject = proceedingJoinPoint.proceed();

        if (returnObject instanceof Connection) {
            return createConnectionProxy((Connection) returnObject);
        } else {
            return returnObject;
        }
    }

    private Connection createConnectionProxy(Connection connection) {
        return (Connection) Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }
}
