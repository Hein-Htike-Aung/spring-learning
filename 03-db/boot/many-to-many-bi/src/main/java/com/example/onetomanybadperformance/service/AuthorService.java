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

        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book2);

        authorRepository.save(author1);
        authorRepository.save(author2);

    }

    @Transactional
    public void findBooksWithAuthorID(Long id) {

        Author author = authorRepository.getById(id);

        if(author != null) {
            System.out.println("Author -> " + author.getName());

            author.getBooks().stream()
                    .filter(Objects::nonNull)
                    .map(book -> book.getTitle())
                    .forEach(System.out::println);
        }
    }

}
