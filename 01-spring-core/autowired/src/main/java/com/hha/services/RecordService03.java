package com.hha.services;

import com.hha.bls.DBRecordProcessor;
import com.hha.nobeans.RecordHash;
import com.hha.nobeans.RecordUtil;
import com.hha.nobeans.RecordValidator;
import com.hha.reader.DBRecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class RecordService03 {

    @Autowired // out of two constructor
    private RecordService03(
            DBRecordsReader dbRecordsReader,
            DBRecordProcessor dbRecordProcessor,
            Optional<RecordUtil> recordUtil,
            @Nullable RecordHash recordHash,
            @Autowired(required = false)RecordValidator recordValidator) {

        // Injection with Constructor (Early Binding)
        System.out.println(getClass().getSimpleName() + " dbRecordsReader = " + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " dbRecordProcessor = " + dbRecordProcessor);
        System.out.println(getClass().getSimpleName() + " recordHash = " + recordHash);
        System.out.println(getClass().getSimpleName() + " recordUtil = " + recordUtil);
        System.out.println(getClass().getSimpleName() + " recordValidator = " + recordValidator);

    }

    //@Autowired
    public RecordService03(
            DBRecordsReader dbRecordsReader,
            DBRecordProcessor dbRecordProcessor) {

        System.out.println(getClass().getSimpleName() + " dbRecordsReader = " + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " dbRecordProcessor = " + dbRecordProcessor);

    }
}
