package com.example.onetomanybadperformance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private int age;

    // Can't add cascade remove cuz One book has many authors
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // Change Join Table name & its columns
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
//    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        // add book to author
        this.books.add(book);

        // add author to book
        book.getAuthors().add(this);
    }

    public void remove(Book book) {
        // remove book from author
        this.remove(book);

        // remove author from book
        book.getAuthors().remove(this);
    }

    public void removeAllBooks() {
        Iterator<Book> itr = this.books.iterator();

        while (itr.hasNext()) {
            Book book = itr.next();

            // remove author from book
            book.getAuthors().remove(this);

            // remove books from author
            itr.remove();
        }
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}
