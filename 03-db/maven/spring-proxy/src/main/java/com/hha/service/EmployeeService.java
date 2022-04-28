package com.hha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class EmployeeService {

    public void transaction1And2() {
        // plain method doesn't support self invocation transaction (transaction will not start)
        transaction01();
        transaction02();
    }

    @Transactional
    public void transaction1And2WithPrecedingTransaction() {
        // it will run under transaction
        // the same transaction context is reused when calling a new @Transactional
        transaction01();
        transaction02();
    }

    @Transactional
    public void transaction01() {
        System.out.println("Transaction 01 method is called");

    }

    @Transactional
    public void transaction02() {
        System.out.println("Transaction 02 method is called");
    }

    @Transactional(rollbackFor = Exception.class)
    public void methodWithCheckedExceptionNoCausingRollBack() throws Exception {
        throw new Exception("Checked Exception will not cause rollback");
    }

    @Transactional
    public void methodWithUncheckedExceptionCausingRollBack() {
        throw new RuntimeException("Unchecked Exception will cause rollback");
    }

}
