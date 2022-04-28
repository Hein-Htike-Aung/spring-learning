package com.hha.services;

import com.hha.validator.RecordValidator;
import com.hha.validator.RecordValidatorType;
import com.hha.writer.RecordWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@Service
public class RecordService03 {

    @Autowired
    @RecordValidatorType(value = RecordValidatorType.RecordValidators.FILE)
    private RecordValidator recordValidator;

    @Autowired
    @RecordValidatorType(value = RecordValidatorType.RecordValidators.DB)
    private RecordValidator recordValidator2;

    @PostConstruct
    private void init() {
        System.out.println("RecordValidator = " + recordValidator.getClass().getSimpleName());
        System.out.println("RecordValidator = " + recordValidator2.getClass().getSimpleName());
    }
}
