package com.example.onetomanybadperformance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.From;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "book_author",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id")
//    )
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {

        // add author to Book
        this.authors.add(author);

        // add book to author
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author) {

        // remove author from book
        authors.remove(author);

        // remove book from author
        author.getBooks().remove(this);
    }

    public void removeAllAuthor() {

        Iterator<Author> itr = authors.iterator();

        while(itr.hasNext()) {
            Author author = itr.next();

            // remove book from author
            author.getBooks().remove(this);

            // remove author from book
            itr.remove();
        }
    }


    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn);
    }
}
