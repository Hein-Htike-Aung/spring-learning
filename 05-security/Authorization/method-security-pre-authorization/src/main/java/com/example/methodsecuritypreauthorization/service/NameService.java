package com.example.methodsecuritypreauthorization.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    private Map<String, List<String>> secretNames = Map.of(
            "xiaoting", List.of("Pretty", "Gorgeous"),
            "karina", List.of("Stunning")
    );

    @PreAuthorize("hasAuthority('write')")
    public String getName() {
        return "Hello!!";
    }

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name) {
        return secretNames.get(name);
    }

}
