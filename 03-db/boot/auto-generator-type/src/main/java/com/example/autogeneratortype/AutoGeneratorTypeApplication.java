package com.example.autogeneratortype;

import com.example.autogeneratortype.entity.Author;
import com.example.autogeneratortype.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoGeneratorTypeApplication implements CommandLineRunner {

    private final AuthorService authorService;

    public AutoGeneratorTypeApplication(AuthorService authorService) {
        this.authorService = authorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AutoGeneratorTypeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author();
        author.setName("Xiaoting");
        author.setAge(32);
        author.setGenre("Science");

        authorService.persistAuthor(author);
    }
}
