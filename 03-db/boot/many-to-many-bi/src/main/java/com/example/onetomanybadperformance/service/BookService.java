package com.example.onetomanybadperformance.service;

import com.example.onetomanybadperformance.entity.Author;
import com.example.onetomanybadperformance.entity.Book;
import com.example.onetomanybadperformance.repository.AuthorRepository;
import com.example.onetomanybadperformance.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void saveBookWithAuthors() {

        Author author1 = new Author();
        author1.setName("Xiao ting");
        author1.setAge(32);
        author1.setGenre("Science");

        Author author2 = new Author();
        author2.setName("Min jeong");
        author2.setAge(22);
        author2.setGenre("Philosophy");

        Book book1 = new Book();
        book1.setIsbn("001");
        book1.setTitle("Dark Psychology");

        Book book2 = new Book();
        book2.setIsbn("0022");
        book2.setTitle("MBTI types");

        book1.addAuthor(author1);
        book1.addAuthor(author2);
        book2.addAuthor(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);

    }

    @Transactional
    public void findAuthorsWithBookID(Long id) {

        Book book = bookRepository.getById(id);

        if(book != null) {
            System.out.println("Book Title -> " + book.getTitle());

            book.getAuthors().stream()
                    .filter(Objects::nonNull)
                    .map(author -> author.getName())
                    .forEach(System.out::println);
        }
    }

}
