package com.hha.writer;

import com.hha.ds.Record;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("file-Writer")
public class FileRecordWriter implements RecordWriter{

    @Override
    public void writeRecords(Collection<Record> records) {

    }
}
