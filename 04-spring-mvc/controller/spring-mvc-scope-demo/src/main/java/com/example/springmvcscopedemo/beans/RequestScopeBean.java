package com.example.springmvcscopedemo.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
public class RequestScopeBean {

    private Integer value;
}
