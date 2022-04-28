package com.hha;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames())

                // extract only BeanDefinition
                .map(configurableListableBeanFactory::getBeanDefinition)

                // Filter to only show the classes which is situated in beans package
                .filter(beanDefinition -> beanClassNameContains(beanDefinition, "com.hha.beans"))

                // extract only Beans Class Name
                .map(BeanDefinition::getBeanClassName)
                .forEach(System.out::println);
    }

    private boolean beanClassNameContains(BeanDefinition beanDefinition, String s) {
        return beanDefinition.getBeanClassName() != null && beanDefinition.getBeanClassName().contains(s);
    }
}
