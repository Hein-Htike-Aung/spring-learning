package com.hha.bls;

import com.hha.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component("dbRecordProcessor")
public class DBRecordProcessor implements RecordProcessor{

    @Override
    public Collection<Record> processRecord(Collection<Record> records) {

        return Collections.emptyList();
    }
}
