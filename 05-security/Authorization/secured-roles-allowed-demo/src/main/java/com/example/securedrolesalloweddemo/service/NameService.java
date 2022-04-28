package com.example.securedrolesalloweddemo.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class NameService {

//    @Secured("ROLE_admin")
    @RolesAllowed("ROLE_manager")
    public String getName() {

        return "Xiaoting is admin";
    }
}
