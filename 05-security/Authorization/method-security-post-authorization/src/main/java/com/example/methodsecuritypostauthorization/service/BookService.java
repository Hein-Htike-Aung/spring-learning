package com.example.methodsecuritypostauthorization.service;

import com.example.methodsecuritypostauthorization.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> records = Map.of(
            "xiaoting", new Employee("Shen Xiaoting", List.of("INTJ", "Philosophy"), List.of("account", "reader")),
            "winter", new Employee("Min Jeong", List.of("Biography"), List.of("researcher"))
    );

    // Authorization with content
    @PostAuthorize("returnObject.roles.contains('reader')") // Only Employee who has reader role
    public Employee getDetails(String name) {
        return records.get(name);
    }
}
