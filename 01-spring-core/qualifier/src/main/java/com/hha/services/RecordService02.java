package com.hha.services;

import com.hha.bls.RecordProcessor;
import com.hha.writer.RecordWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@Service
public class RecordService02 {

    @Autowired
    @Qualifier("db-record-writer")
    private RecordWriter recordWriter;

    @Autowired
    @Qualifier("file-Writer")
    private RecordWriter recordWriter2;

    @PostConstruct
    private void init() {

        System.out.println("RecordWriter = " + recordWriter.getClass().getSimpleName());
        System.out.println("RecordWriter = " + recordWriter2.getClass().getSimpleName());
    }
}
