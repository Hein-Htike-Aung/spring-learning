package com.example.rolebasedpostauthorization.controller;

import com.example.rolebasedpostauthorization.model.Document;
import com.example.rolebasedpostauthorization.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // curl -u xiaoting:12345 localhost:8080/document/kepler
    // curl -u xiaoting:12345 localhost:8080/document/aespa
    // curl -u karina:12345 localhost:8080/document/kepler
    // curl -u karina:12345 localhost:8080/document/aespa
    @GetMapping("/document/{code}")
    public Document getDocument(@PathVariable String code) {
        return documentService.getDocument(code);

//        return documentService.getDocument2(code);
    }

}
