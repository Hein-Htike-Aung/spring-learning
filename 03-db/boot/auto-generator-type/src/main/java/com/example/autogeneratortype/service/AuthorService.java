package com.example.autogeneratortype.service;

import com.example.autogeneratortype.entity.Author;
import com.example.autogeneratortype.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void persistAuthor(Author author) {

        authorRepository.save(author);
    }
}
