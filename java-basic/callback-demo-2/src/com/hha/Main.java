package com.hha;

import com.hha.expression.AddExpressionEvaluator;
import com.hha.expression.MinusExpressionEvaluator;
import com.hha.printer.DecoratedValuePrinter;

public class Main {

    public static void main(String[] args) {

        NumberEvaluator numberEvaluator = new NumberEvaluator();

        numberEvaluator.evaluate(2, new AddExpressionEvaluator(), new DecoratedValuePrinter());

        numberEvaluator.evaluate(2, new MinusExpressionEvaluator(), new DecoratedValuePrinter());


    }
}
