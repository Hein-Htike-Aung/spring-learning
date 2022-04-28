package com.hha.backup;

import com.hha.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DBRecordBackup implements RecordBackup{

    @Override
    public void backupRecords(Collection<Record> records) {

    }
}
