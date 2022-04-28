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
public class Author implements Serializable { // Parent Table

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private int age;


    // (orphanRemoval = true) If parent doesn't exist, Child also isn't going to exist
    // if author cascades, All books are going to cascade

    @OneToMany(mappedBy = "author", cascade = {CascadeType.ALL}, orphanRemoval = true)
//    @JoinColumn(name = "author_id_fk") // Bi Direction
//    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Book> bookList = new ArrayList<>();


    public void addBook(Book book) {
        this.bookList.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        this.bookList.remove(book);
    }

    public void removeBooks() {

        Iterator<Book> itr = this.bookList.iterator();

        while (itr.hasNext()) {
            Book book = itr.next();
            book.setAuthor(null);
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
