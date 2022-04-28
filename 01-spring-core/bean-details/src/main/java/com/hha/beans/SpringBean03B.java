package com.hha.beans;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class SpringBean03B implements SpringBean03{

    @Override
    public void printHash() {

        System.out.println(getClass().getSimpleName() + "::No Implementation yet!!");
    }
}
