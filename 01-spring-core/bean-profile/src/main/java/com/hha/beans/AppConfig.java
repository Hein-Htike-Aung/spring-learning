package com.hha.beans;

import com.hha.beans.mappers.DataMapper;
import com.hha.beans.processor.DataProcessor;
import com.hha.beans.processor.MultiSourceDataProcessor;
import com.hha.beans.reader.DataReader;
import com.hha.beans.reader.DbDataReader;
import com.hha.beans.reader.FileDataReader;
import com.hha.beans.writer.DataWriter;
import com.hha.beans.writer.DevDataWriter;
import com.hha.beans.writer.ProdDataWriter;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public DataMapper dataMapper() {
        return new DataMapper();
    }

    @Bean
    @Profile({"database", "file"})
    public DataProcessor multiSourceDataProcessor() {
        return new MultiSourceDataProcessor();
    }

    @Bean
    @Profile("database")
    public DataReader dbDataReader() {
        return new DbDataReader();
    }

    @Bean
    @Profile("file")
    public DataReader fileDataReader() {
        return new FileDataReader();
    }

    @Bean
    @Profile("!prod")
    public DataWriter devDataWriter() {
        return new DevDataWriter();
    }

    @Bean
    @Profile("!dev")
    public DataWriter prodDataWriter() {
        return new ProdDataWriter();
    }
}
