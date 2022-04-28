package com.hha.definitions.custom.annotation.annotation;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Profile("file")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FileProfile {
}
