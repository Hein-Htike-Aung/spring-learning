package com.hha.reader;

import com.hha.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DBRecordsReader implements RecordsReader{

    @Override
    public Collection<Record> readRecords() {
        return Collections.emptyList();
    }
}
