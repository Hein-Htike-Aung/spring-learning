package com.example.onetomanybadperformance;

import com.example.onetomanybadperformance.service.AuthorService;
import com.example.onetomanybadperformance.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyBadPerformanceApplication implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyBadPerformanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        System.out.println("\n\n--------------------------------------------\n\n");
//        System.out.println("\nInsert Author with Books");
//        authorService.saveAuthorWithBooks();

        System.out.println("\n\n--------------------------------------------\n\n");
        System.out.println("\nInsert Book with Authors");
        bookService.saveBookWithAuthors();

        System.out.println("\n\n--------------------------------------------\n\n");
        System.out.println("Author1 Books");
        authorService.findBooksWithAuthorID(1L);

        System.out.println("\n\n--------------------------------------------\n\n");
        System.out.println("Author2 Books");
        authorService.findBooksWithAuthorID(2L);

        System.out.println("\n\n--------------------------------------------\n\n");
        System.out.println("Books with Author");
        bookService.findAuthorsWithBookID(1L);
    }
}
