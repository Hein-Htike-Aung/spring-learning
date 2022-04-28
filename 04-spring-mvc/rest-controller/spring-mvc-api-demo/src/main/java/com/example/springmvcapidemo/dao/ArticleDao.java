package com.example.springmvcapidemo.dao;

import com.example.springmvcapidemo.ds.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {


    List<Article> findByBodyLikeIgnoreCase(String content);
}
