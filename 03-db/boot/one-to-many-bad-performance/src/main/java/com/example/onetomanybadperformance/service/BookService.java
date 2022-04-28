package com.example.onetomanybadperformance.service;

import com.example.onetomanybadperformance.entity.Author;
import com.example.onetomanybadperformance.entity.Book;
import com.example.onetomanybadperformance.repository.AuthorRepository;
import com.example.onetomanybadperformance.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void insertNewBookWithAuthor() {

        Author author = authorRepository.fetchByName("Xiao ting");

        Book book = new Book();
        book.setIsbn("0034");
        book.setTitle("Thinking Fast & Slow");

        author.addBook(book);

        authorRepository.save(author);
    }

    @Transactional
    public void deleteLastBookWithAuthor() {

        Author author = authorRepository.fetchByName("Xiao ting");

        List<Book> bookList = author.getBookList();

        author.removeBook(bookList.get(bookList.size() - 1));

    }

    @Transactional
    public void deleteFirstBookWithAuthor() {

        Author author = authorRepository.fetchByName("Xiao ting");

        List<Book> bookList = author.getBookList();

        author.removeBook(bookList.get(0));

    }

    @Transactional
    public void deleteAllBooksWithAuthor() {

        Author author = authorRepository.fetchByName("Xiao ting");
        author.removeBooks();

    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
