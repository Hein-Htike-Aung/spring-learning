package com.hha.backup;

import com.hha.ds.Record;

import java.util.Collection;

public interface RecordBackup {
    
    void backupRecords(Collection<Record> records);
}
