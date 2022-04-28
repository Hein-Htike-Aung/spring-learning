package com.hha.java.config.context;

import com.hha.java.config.context.beans.SpringBeans01;
import com.hha.java.config.context.beans.SpringBeans02;
import com.hha.java.config.context.beans.SpringBeans03;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

@Configuration
public class AppConfig {

    @Bean
    public SpringBeans01 springBeans01(SpringBeans02 springBeans02, SpringBeans03 springBeans03, MessageDigest messageDigest) {
        return new SpringBeans01(springBeans02, springBeans03, messageDigest);
    }

    @Bean
    public SpringBeans02 springBeans02(){
        return new SpringBeans02();
    }

    @Bean
    public SpringBeans03 springBeans03(){
        return new SpringBeans03();
    }

    // Third Party class being transferred into Spring Bean
    @Bean
    public MessageDigest messageDigest() {
        return DigestUtils.getSha384Digest();
    }
}
