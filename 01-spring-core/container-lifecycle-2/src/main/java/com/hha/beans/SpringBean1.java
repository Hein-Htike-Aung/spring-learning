package com.hha.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 implements InitializingBean, DisposableBean {

    @Autowired
    private SpringBean2 springBean2;

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet()");
    }

    @Bean(initMethod = "initMethod")
    private void initMethod() {
        System.out.println("@Bean::initMethod()\n\n");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy()");
    }

    @Bean(destroyMethod = "destroyMethod")
    private void destroyMethod() {
        System.out.println("@Bean::destroyMethod()");
    }

}
