package com.hha.beans;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class SpringBean03A implements SpringBean03{

    private final MessageDigest messageDigest;

    public SpringBean03A(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    @Override
    public void printHash() {

        byte[] hashBytes = messageDigest.digest("Hein Htike Aung".getBytes());
        char[] hashString = Hex.encodeHex(hashBytes);

        System.out.println(hashString);
    }
}
