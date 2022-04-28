package com.example.securitycontextdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class IndexController {

    private Logger log = LoggerFactory.getLogger(IndexController.class.getName());

    // curl -u user:f55f318f-7e39-426d-94d7-8d228d0bd3a3 localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {

        // Authentication Details are stored in SecurityContext
        // One request has one threat with one SecurityContext

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();

        return "Authentication -> " + authentication.getName();
    }

    // curl -u user:f55f318f-7e39-426d-94d7-8d228d0bd3a3 localhost:8080/bye
    @GetMapping("/bye")
//    @Async
    public String bye() {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();

        return "Authentication -> " + authentication.getName();

    }

    // curl -u user:f55f318f-7e39-426d-94d7-8d228d0bd3a3 localhost:8080/good
    @GetMapping("/good")
    public String good() throws Exception {

        // Java Concurrency
        Callable<String> task = () -> {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            return securityContext.getAuthentication().getName();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService = new DelegatingSecurityContextExecutorService(executorService);

        try {
            return "Authentication " + executorService.submit(task).get();
        } finally {
            executorService.shutdown();
        }

    }
}
