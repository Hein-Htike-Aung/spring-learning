package com.hha.services;

import com.hha.bls.DBRecordProcessor;
import com.hha.bls.RecordProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RecordService01 {

    @Autowired
    @Qualifier("dbRecordProcessor")
    private RecordProcessor recordProcessor;

    @Autowired
    @Qualifier("fileRecordProcessor")
    private RecordProcessor recordProcessor2;

    @PostConstruct
    private void init(){

        System.out.println("RecordProcessor = " + recordProcessor.getClass().getSimpleName());
        System.out.println("RecordProcessor = " + recordProcessor2.getClass().getSimpleName());
    }
}
