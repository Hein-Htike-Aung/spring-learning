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

        System.out.println("\nInsert Author with Books");
        authorService.saveAuthorWithBooks();

        System.out.println("\n\n--------------------------------------------\n\n");

        System.out.println("\nInsert New Book with Author");
        bookService.insertNewBookWithAuthor();

        System.out.println("\n\n--------------------------------------------\n\n");

        System.out.println("\nAll Books");
        bookService.findAll().forEach(System.out::println);

        System.out.println("\n\n--------------------------------------------\n\n");

//        System.out.println("\nDelete First Book with Author");
//        bookService.deleteFirstBookWithAuthor();
//
//        System.out.println("\nDelete Last Book with Author");
//        bookService.deleteLastBookWithAuthor();

//        System.out.println("\nAuthorWithBooks");
//        authorService.authorWithBooks();

//        System.out.println("\n\n--------------------------------------------\n\n");

        System.out.println("\nDelete All books of Author");
        bookService.deleteAllBooksWithAuthor();

        System.out.println("\n\n--------------------------------------------\n\n");

        System.out.println("\nAuthorWithBooks");
        authorService.authorWithBooks();

    }
}
