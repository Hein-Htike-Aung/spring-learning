package com.hha.validator;

import com.hha.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RecordValidatorType(value = RecordValidatorType.RecordValidators.FILE)
public class FileRecordValidator implements RecordValidator{

    @Override
    public void validate(Collection<Record> records) {

    }
}
