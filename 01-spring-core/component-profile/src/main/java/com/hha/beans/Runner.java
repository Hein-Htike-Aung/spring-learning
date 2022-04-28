package com.hha.beans;

import com.hha.beans.mappers.DataMapper;
import com.hha.beans.processor.DataProcessor;
import com.hha.beans.reader.DataReader;
import com.hha.beans.writer.DataWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file", "dev");
//        context.getEnvironment().setActiveProfiles("database", "dev");
//        context.getEnvironment().setActiveProfiles("file", "prod");
//        context.getEnvironment().setActiveProfiles("database", "prod");
//        context.getEnvironment().setActiveProfiles("file");
//        context.getEnvironment().setActiveProfiles("database");
//        context.getEnvironment().setActiveProfiles("prod");
//        context.getEnvironment().setActiveProfiles("dev");


        context.register(AppConfig.class);
        context.refresh();

        System.out.println(context.getBean(DataMapper.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataProcessor.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataReader.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataWriter.class).getClass().getSimpleName());
    }
}
