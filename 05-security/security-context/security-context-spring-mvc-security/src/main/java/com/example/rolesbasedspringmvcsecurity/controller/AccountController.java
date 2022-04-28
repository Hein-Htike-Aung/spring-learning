package com.example.rolesbasedspringmvcsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Controller
public class AccountController {


    private static final String MAIN = "main";
    private static final String CHILD = "child";

    @GetMapping("/account")
    public String account(Model model) throws InterruptedException {

        // To Test MODE_GLOBAL
        TimeUnit.SECONDS.sleep(3);

        // SecurityContextHolder.getContextHolderStrategy() came from SecurityStrategyConfiguration
        model.addAttribute("securityContextHolderStrategy",
                SecurityContextHolder.getContextHolderStrategy().getClass().getSimpleName());

        // MODE_THREADLOCAL (Child Thread doesn't work) (One user One Thread One Security Context)
        // MODE_INHERITABLETHREADLOCAL (One user (Main Thread + Child Thread) one security Context)
        // MODE_GLOBAL (All the users are in one Security Context)

        storeSecurityContextDataInMainThread(model);
        storeSecurityContextDataInChildThread(model);



        return "account";
    }


    private void storeSecurityContextDataInMainThread(Model model) {

        storeSecurityContextDataInModel(MAIN, model);
    }

    private void storeSecurityContextDataInChildThread(Model model) throws InterruptedException {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                storeSecurityContextDataInModel(CHILD, model);
//            }
//        };

        Thread thread = new Thread(() -> storeSecurityContextDataInModel(CHILD, model));

        /*
         *Thread start() means create another Thread (Not Main Thread)
         * */
        thread.start();

        // Go to Dead State
        thread.join();
    }

    private void storeSecurityContextDataInModel(String prefix, Model model) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .orElse(null);

        model.addAttribute(prefix + "HashCode", Integer.toHexString(securityContext.hashCode()));

        model.addAttribute(
                prefix + "Name",
                Optional.ofNullable(authentication)
                        .map(Authentication::getName)
                        .orElse("N/A")
        );

        model.addAttribute(
                prefix + "Username",
                Optional.ofNullable(user)
                        .map(User::getUsername)
                        .orElse("N/A")
        );

        model.addAttribute(
                prefix + "Authorities",
                Optional.ofNullable(authentication)
                        .map(Authentication::getAuthorities)
                        .orElse(null)
        );


    }
}
