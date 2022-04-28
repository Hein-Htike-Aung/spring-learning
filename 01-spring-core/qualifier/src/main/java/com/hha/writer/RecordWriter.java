package com.hha.writer;

import com.hha.ds.Record;

import java.util.Collection;

public interface RecordWriter {

    void writeRecords(Collection<Record> records);
}
