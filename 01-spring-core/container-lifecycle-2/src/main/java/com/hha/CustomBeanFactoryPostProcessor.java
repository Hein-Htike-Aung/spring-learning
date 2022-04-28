package com.hha;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Configuration Class
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("BeanFactoryPostProcessor start!!");

        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())

                .map(configurableListableBeanFactory::getBeanDefinition)

                .filter(beanDefinition -> beanClassFilter(beanDefinition, "com.hha.beans"))

                .map(BeanDefinition::getBeanClassName)

                .forEach(System.out::println);

        System.out.println("BeanFactoryPostProcessor End!!\n\n");
    }

    private boolean beanClassFilter(BeanDefinition beanDefinition, String s) {
        return beanDefinition.getBeanClassName() != null && beanDefinition.getBeanClassName().contains(s);
    }
}
