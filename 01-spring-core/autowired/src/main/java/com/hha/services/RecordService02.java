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
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class RecordService02 {

    public RecordService02(
            DBRecordsReader dbRecordsReader,
            DBRecordBackup dbRecordBackup,
            DBRecordProcessor dbRecordProcessor,
            @Nullable RecordHash recordHash,
            Optional<RecordUtil> recordUtil,
            @Autowired(required = false) RecordValidator recordValidator,
            DBRecordWriter dbRecordWriter) {

        System.out.println(getClass().getSimpleName() + " dbRecordsReader = " + dbRecordsReader);
        System.out.println(getClass().getSimpleName() + " dbRecordBackup = " + dbRecordBackup);
        System.out.println(getClass().getSimpleName() + " dbRecordProcessor = " + dbRecordProcessor);
        System.out.println(getClass().getSimpleName() + " dbRecordWriter = " + dbRecordWriter);
        System.out.println(getClass().getSimpleName() + " recordHash = " + recordHash);
        System.out.println(getClass().getSimpleName() + " recordUtil = " + recordUtil);
        System.out.println(getClass().getSimpleName() + " recordValidator = " + recordValidator);
    }
}
