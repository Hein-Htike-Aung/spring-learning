package com.hha.validator;

import com.hha.ds.Record;

import java.util.Collection;

public interface RecordValidator {

    void validate(Collection<Record> records);
}
