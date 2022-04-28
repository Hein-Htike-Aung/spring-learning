package com.hha.services;

import com.hha.backup.DBRecordBackup;
import com.hha.bls.DBRecordProcessor;
import com.hha.nobeans.RecordHash;
import com.hha.nobeans.RecordUtil;
import com.hha.nobeans.RecordValidator;
import com.hha.reader.DBRecordsReader;
import com.hha.writer.DBRecordWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

//@Service
public class RecordService01 {

    @Autowired
    public DBRecordsReader dbRecordsReader;

    @Autowired
    protected DBRecordBackup dbRecordBackup;

    @Autowired
    private DBRecordProcessor dbRecordProcessor;

    @Autowired
    DBRecordWriter dbRecordWriter;

    // Interface with no implementation class
    @Autowired
    private Optional<RecordHash> recordHash;

    // Interface with no implementation class
    @Autowired
    @Nullable
    private RecordUtil recordUtil;

    // Interface with no implementation class
    @Autowired(required = false)
    private RecordValidator recordValidator;

    public RecordService01() {
        System.out.println("\n\nIn Constructor...");
        System.out.println(getClass().getSimpleName() + " dbRecordsReader = " + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " dbRecordBackup = " + dbRecordBackup);
        System.out.println(getClass().getSimpleName() + " dbRecordProcessor = " + dbRecordProcessor);
        System.out.println(getClass().getSimpleName() + " dbRecordWriter = " + dbRecordWriter);
        System.out.println(getClass().getSimpleName() + " recordHash = " + recordHash);
        System.out.println(getClass().getSimpleName() + " recordUtil = " + recordUtil);
        System.out.println(getClass().getSimpleName() + " recordValidator = " + recordValidator);
        System.out.println();
    }

    @PostConstruct
    private void init() {
        // Fields have Injected
        System.out.println(getClass().getSimpleName() + " dbRecordsReader = " + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " dbRecordBackup = " + dbRecordBackup);
        System.out.println(getClass().getSimpleName() + " dbRecordProcessor = " + dbRecordProcessor);
        System.out.println(getClass().getSimpleName() + " dbRecordWriter = " + dbRecordWriter);
        System.out.println(getClass().getSimpleName() + " recordHash = " + recordHash);
        System.out.println(getClass().getSimpleName() + " recordUtil = " + recordUtil);
        System.out.println(getClass().getSimpleName() + " recordValidator = " + recordValidator);

    }
}
