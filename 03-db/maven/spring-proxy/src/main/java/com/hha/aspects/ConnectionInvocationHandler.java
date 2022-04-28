package com.hha.aspects;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConnectionInvocationHandler implements InvocationHandler {

    private final Connection connection;

    private static Set<String> LOGGABLE_METHOD = new HashSet(Arrays.asList(
            "commit", "rollback", "close"
    ));

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(shouldLogInvocation(method)) {

            System.out.println("InvocationHandler : " + method.toGenericString());
        }

        return method.invoke(connection, args);

    }

    private boolean shouldLogInvocation(Method method) {

        return LOGGABLE_METHOD.contains(method.getName());
    }
}
