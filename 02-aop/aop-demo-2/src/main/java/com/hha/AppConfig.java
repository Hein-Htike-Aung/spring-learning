package com.hha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass = true) -> Only work with CGLIB Proxy
public class AppConfig {

}
