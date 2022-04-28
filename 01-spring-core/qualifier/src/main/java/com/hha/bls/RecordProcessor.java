package com.hha.bls;

import com.hha.ds.Record;

import java.util.Collection;

public interface RecordProcessor {

    Collection<Record> processRecord(Collection<Record> records);
}
