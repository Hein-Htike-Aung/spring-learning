package com.hha.reader;

import com.hha.ds.Record;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Order(2)
public class SocketRecordReader implements RecordsReader{

    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
