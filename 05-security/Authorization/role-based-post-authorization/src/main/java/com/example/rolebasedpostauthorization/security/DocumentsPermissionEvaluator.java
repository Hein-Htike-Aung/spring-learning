package com.example.rolebasedpostauthorization.security;

import com.example.rolebasedpostauthorization.Repository.DocumentRepository;
import com.example.rolebasedpostauthorization.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Object targetDomainObject,
            Object permission) {

        // targetDomainObject -> return Object
        // permission -> ROLE_admin

        Document document = (Document) targetDomainObject;

        boolean admin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(permission.toString()));

        // owner and admin will be authorized
        return admin || document.getOwner().equals(authentication.getName());
    }

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Serializable targetId,
            String targetType,
            Object permission) {

        // targetId -> code (method's parameter)
        // targetType ->  document
        // permission -> ROLE_admin
        String code = targetId.toString();

        Document document = documentRepository.findDocument(code);

        boolean admin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(permission.toString()));

        return admin || document.getOwner().equals(authentication.getName());
    }
}
