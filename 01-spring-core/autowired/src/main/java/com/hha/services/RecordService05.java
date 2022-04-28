package com.hha.services;

import com.hha.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService05 {

    @Autowired // Setter needs @Autowired
    public void setRecordsReader(List<RecordsReader> recordsReaders) {

        System.out.println(getClass().getSimpleName() + " setRecordsReader");

        recordsReaders.stream()
                .map(recordsReader -> "\t" + recordsReader.getClass().getSimpleName())
                .forEach(System.out::println);
    }
}
