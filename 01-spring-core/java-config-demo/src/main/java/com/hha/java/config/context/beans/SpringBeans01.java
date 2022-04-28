package com.hha.java.config.context.beans;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

public class SpringBeans01 {

    private final SpringBeans02 springBeans02;

    private final SpringBeans03 springBeans03;

    private final MessageDigest messageDigest;

    public SpringBeans01(SpringBeans02 springBeans02, SpringBeans03 springBeans03, MessageDigest messageDigest) {
        this.springBeans02 = springBeans02;
        this.springBeans03 = springBeans03;
        this.messageDigest = messageDigest;
    }

    public void printDependencies() {
        System.out.println("Config with Java");
        System.out.println(springBeans02.getClass().getSimpleName());
        System.out.println(springBeans03.getClass().getSimpleName());

        byte[] hashBytes = messageDigest.digest("password".getBytes());
        char[] hashStrings = Hex.encodeHex(hashBytes);
        System.out.println(hashStrings);
    }
}
