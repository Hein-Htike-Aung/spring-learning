package com.example.todolistdemo.repo;

import com.example.todolistdemo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
