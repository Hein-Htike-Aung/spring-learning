package com.example.transactiondemo.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

    private final Connection connection;

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("ConnectionInvocationHandler Connection trace: " + method.toGenericString());

        return method.invoke(connection, args);
    }
}
