package com.example.rolebasedpostauthorization.service;

import com.example.rolebasedpostauthorization.Repository.DocumentRepository;
import com.example.rolebasedpostauthorization.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    // authorize with PermissionEvaluator
    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Document getDocument(String code) {

        return documentRepository.findDocument(code);
    }

    @PostAuthorize("hasPermission(#code, 'document', 'ROLE_admin')")
    public Document getDocument2(String code) {
        return documentRepository.findDocument(code);
    }
}
