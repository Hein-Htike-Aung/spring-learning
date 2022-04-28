package com.example.onetomanybadperformance.repository;

import com.example.onetomanybadperformance.entity.Author;
import com.example.onetomanybadperformance.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {

}
