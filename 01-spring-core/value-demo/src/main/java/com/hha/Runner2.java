package com.hha;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

public class Runner2 {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("'Hello'.concat('World')").getValue());

        System.out.println(parser.parseExpression("2 + 2").getValue());

        System.out.println(parser.parseExpression("new String('Xiao ting').toUpperCase()").getValue());

        System.out.println(parser.parseExpression("23 * 3").getValue());

        System.out.println(parser.parseExpression("{1, 2, 3}").getValue());

        System.out.println(parser.parseExpression("{a: 1, b: 2, c: 3}").getValue());

        // Dynamic Array
        System.out.println(Arrays.toString((int[]) parser.parseExpression("new Int[]{1, 2, 3}").getValue()));

        System.out.println(parser.parseExpression("5 < 10").getValue());
    }
}
