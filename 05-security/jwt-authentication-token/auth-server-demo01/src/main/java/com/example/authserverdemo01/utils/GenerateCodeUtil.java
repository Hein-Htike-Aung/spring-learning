package com.example.authserverdemo01.utils;

import java.security.SecureRandom;

public final class GenerateCodeUtil {

    private GenerateCodeUtil() {
    }

    public static String generateCode() {

        String code = "";

        try {

            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            code = String.valueOf(secureRandom.nextInt(9000) + 1000); // 0 to 8999

        } catch (Exception e) {

            throw new RuntimeException("Problem occurred during Generating Code!");

        }

        return code;
    }
}
