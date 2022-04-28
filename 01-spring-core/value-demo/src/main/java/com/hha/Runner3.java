package com.hha;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Runner3 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        // has an ability to resolve Spring Beans
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setBeanResolver(new BeanFactoryResolver(context));

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(
                parser.parseExpression("@springBean01.streetName").getValue(evaluationContext)
        );

        System.out.println(
                parser.parseExpression("@springBean01.accountBalance + 1000").getValue(evaluationContext)
        );

        System.out.println(
                parser.parseExpression("@springBean01.casesMap.get('caseB')").getValue(evaluationContext)
        );

    }
}
