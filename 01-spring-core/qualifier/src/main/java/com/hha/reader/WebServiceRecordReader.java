package com.hha.reader;

import com.hha.ds.Record;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Collection;

@Component
@Priority(1)
public class WebServiceRecordReader implements RecordsReader{

    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
