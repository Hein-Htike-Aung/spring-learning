package com.haa.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

    private final Connection connection;

    public ConnectionInvocationHandler(Connection connection) {
        // connection = returnObject
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // -------Without Transaction
        // args = insert into employee(employee_id, first_name, last_name, email, phone, hire_date, salary)values (?,?,?,?,?,?,?)
        // connection = returnObject

        // --------With Transaction
        // args = false
        // args = insert into employee(employee_id, first_name, last_name, email, phone, hire_date, salary)values (?,?,?,?,?,?,?)
        // args = true

        System.out.println("InvocationHandler trace: " + method.toGenericString());

        return method.invoke(connection, args);
    }
}
