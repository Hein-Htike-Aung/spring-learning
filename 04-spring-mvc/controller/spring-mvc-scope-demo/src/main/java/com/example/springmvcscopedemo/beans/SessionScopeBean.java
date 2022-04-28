package com.example.springmvcscopedemo.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Data
@Component
public class SessionScopeBean {

    private Integer value;
}


