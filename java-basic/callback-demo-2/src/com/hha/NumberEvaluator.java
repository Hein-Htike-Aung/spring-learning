package com.hha;

import com.hha.ds.Pair;
import com.hha.expression.ExpressionEvaluator;
import com.hha.printer.ValuePrinter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberEvaluator {

    public void evaluate(int i, ExpressionEvaluator expressionEvaluator, ValuePrinter valuePrinter) {

//        i = 2
        List<Pair> pairs = generatePairs(i);

//        a = 1, b = 4   a = 2, b = 4

        for (Pair pair : pairs) {
            valuePrinter.print(
                    // Callback
                expressionEvaluator.evaluate(pair.getA(), pair.getB())
            );
        }
    }

    private List<Pair> generatePairs(int i) {

        return IntStream.range(1, i + 1)

                // if i is 2 -> n starts with 1, end with less than 3

                // callback
                .mapToObj(n -> new Pair(n, 2 * i))
                .collect(Collectors.toList());
    }
}
