package com.example.onetomanybadperformance.repository;

import com.example.onetomanybadperformance.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a join fetch a.bookList where a.name = ?1")
    Author fetchByName(String name);
}
