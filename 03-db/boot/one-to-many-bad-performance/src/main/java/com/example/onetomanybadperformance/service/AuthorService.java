package com.example.onetomanybadperformance.service;

import com.example.onetomanybadperformance.entity.Author;
import com.example.onetomanybadperformance.entity.Book;
import com.example.onetomanybadperformance.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void saveAuthorWithBooks() {

        Author author = new Author();
        author.setName("Xiao ting");
        author.setAge(32);
        author.setGenre("Science");

        Book book1 = new Book();
        book1.setIsbn("001");
        book1.setTitle("Dark Psychology");

        Book book2 = new Book();
        book2.setIsbn("0022");
        book2.setTitle("MBTI types");

        author.addBook(book1);
        author.addBook(book2);

        authorRepository.save(author);

    }

    @Transactional
    public void authorWithBooks() {

//        Author author = authorRepository.fetchByName("Xiao ting");

        Author author = authorRepository.getById(1L);

        System.out.println("Author -> " +  author.getName());

        if(!author.getBookList().isEmpty()) {

            author.getBookList().stream()
                    .filter(Objects::nonNull)
                    .map(book -> "Books -> " + book.getTitle()).forEach(System.out::println);
        }


    }

}
