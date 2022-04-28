package com.hha;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Arrays;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().getSimpleName().contains("SpringBean1")) {
            System.out.println(String.format("BeanPostProcessor::postProcessBeforeInitialization::%s %s",
                    bean.getClass().getSimpleName(), beanName));

        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean.getClass().getSimpleName().contains("SpringBean1")) {
            System.out.println(String.format("BeanPostProcessor::postProcessAfterInitialization::%s %s",
                    bean.getClass().getSimpleName(), beanName));
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
