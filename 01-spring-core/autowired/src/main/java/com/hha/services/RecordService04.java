package com.hha.services;

import com.hha.nobeans.RecordValidator;
import com.hha.reader.DBRecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

//@Service
public class RecordService04 {

    @Autowired
    public void setRecordsReader(DBRecordsReader dbRecordsReader) {

        // Injection with Setter (Late Binding)
        System.out.println(getClass().getSimpleName() + " setRecordsReader = " + dbRecordsReader);
        System.out.println();
    }

    @Autowired
    //@Autowired(required = false)
    public void setRecordsAndRecordsValidator(
            DBRecordsReader dbRecordsReader,
            @Nullable RecordValidator recordValidator) {

        System.out.println(getClass().getSimpleName() + " setRecordsAndRecordsValidator::" + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " setRecordsAndRecordsValidator::" + recordValidator);
    }
}
