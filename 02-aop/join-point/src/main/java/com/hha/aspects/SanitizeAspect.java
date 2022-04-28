package com.hha.aspects;

import com.hha.annotations.Sanitize;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Component
@Aspect
public class SanitizeAspect {

    // Manipulation Method Parameters
    @Around("execution(* com..beans.*.*(*, ..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        return proceedingJoinPoint.proceed(
                sanitizeArgumentsIfRequired(proceedingJoinPoint.getArgs(), methodSignature)
                // finalize Object Array -> [A001, amount = 50, *** sanitized ***]
        );
    }

    private Object[] sanitizeArgumentsIfRequired(Object[] args, MethodSignature methodSignature) {

        // args -> 0 = "A001" 1 = "amount = 50" 2 = "private-key-3434"
        Object[] filterArgs = new Object[args.length];

        for (int i = 0; i < filterArgs.length; i++) {
            // methodSignature.getMethod().getParameterAnnotations()[i] -> Two Dimension Array
            filterArgs[i] = sanitizeArgumentIfRequired(args[i], methodSignature.getMethod().getParameterAnnotations()[i]);
        }

        return filterArgs;
    }

    private Object sanitizeArgumentIfRequired(Object arg, Annotation[] parameterAnnotation) {

        // Parameter Type must be String class with @Sanitize Annotation
        if(containAnnotationType(parameterAnnotation, Sanitize.class) && arg.getClass() == String.class){
            return "*** sanitized ***";
        }else {
            return arg;
        }
    }

    private boolean containAnnotationType(Annotation[] parameterAnnotation, Class<Sanitize> sanitizeClass) {

        return Arrays.stream(parameterAnnotation)
                .map(Annotation::annotationType)
                .anyMatch(sanitizeClass::equals);

    }
}
