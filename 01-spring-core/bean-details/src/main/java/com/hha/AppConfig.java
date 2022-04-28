package com.hha;

import com.hha.beans.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

@Configuration
public class AppConfig {

    @Bean(initMethod = "init")
    public SpringBean01 springBean01(SpringBean02 springBean02, SpringBean03 springBean3A) {
        return new SpringBean01(springBean02, springBean3A);
    }

//    @Bean(initMethod = "init")
//    public SpringBean01 springBean01(SpringBean02 springBean02, SpringBean03 springBean2nd) {
//        return new SpringBean01(springBean02, springBean2nd);
//    }
//
//    @Bean(initMethod = "init")
//    public SpringBean01 springBean01(SpringBean02 springBean02, SpringBean03 springBean03C) {
//        return new SpringBean01(springBean02, springBean03C);
//    }

    @Bean(destroyMethod = "destroy")
    public SpringBean02 springBean02() {
        return new SpringBean02();
    }

    @Bean(name = "springBean3A")
    public SpringBean03 springBean03A(MessageDigest messageDigest) {
        return new SpringBean03A(messageDigest);
    }

    @Bean(name = {"springBean2nd", "springBean3B"})
    public SpringBean03 springBean03B() {
        return new SpringBean03B();
    }

    @Bean
    public SpringBean03 springBean03C() {
        return new SpringBean03C();
    }

    @Bean
    public MessageDigest messageDigest() {
        return DigestUtils.getSha384Digest();
    }
}
