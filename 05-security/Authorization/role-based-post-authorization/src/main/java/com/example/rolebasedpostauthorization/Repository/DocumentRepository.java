package com.example.rolebasedpostauthorization.Repository;

import com.example.rolebasedpostauthorization.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {

    private Map<String, Document> documents = Map.of(
            "kepler", new Document("xiaoting"),
            "aespa", new Document("karina")
    );

    public Document findDocument(String code) {
        return documents.get(code);
    }
}
