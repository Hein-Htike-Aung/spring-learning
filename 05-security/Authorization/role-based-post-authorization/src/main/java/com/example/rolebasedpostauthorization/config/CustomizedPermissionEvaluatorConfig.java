package com.example.rolebasedpostauthorization.config;

import com.example.rolebasedpostauthorization.security.DocumentsPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomizedPermissionEvaluatorConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private DocumentsPermissionEvaluator documentsPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {

        // Set Customize PermissionEvaluator
        var abstractSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();

        abstractSecurityExpressionHandler.setPermissionEvaluator(documentsPermissionEvaluator);

        return abstractSecurityExpressionHandler;
    }

}
