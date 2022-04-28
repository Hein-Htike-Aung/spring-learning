package com.hha.reader;

import com.hha.ds.Record;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class FileRecordReader implements RecordsReader, Ordered {

    @Override
    public Collection<Record> readRecords() {
        return Collections.emptyList();
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
