package com.example.springmvcapidemo.controller;

import com.example.springmvcapidemo.dao.ArticleDao;
import com.example.springmvcapidemo.ds.Article;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/articles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    @Autowired
    private ArticleDao articleDao;

    // curl http://localhost:8080/api/articles/creation
    @Transactional
    @GetMapping("/creation")
    public String initData() {

        Article article = new Article(1, "First Article", "First Content for Article 1");
        Article article2 = new Article(2, "Second Article", "Second Content for Article 2");
        Article article3 = new Article(3, "Third Article", "Third Content for Article 3");
        Article article4 = new Article(4, "Fourth Article", "Fourth Content for Article 4");
        Article article5 = new Article(5, "Fifth Article", "Fifth Content for Article 5");

        articleDao.save(article);
        articleDao.save(article2);
        articleDao.save(article3);
        articleDao.save(article4);
        articleDao.save(article5);

        return "success";
    }

    // curl http://localhost:8080/api/articles/ |jq
    @GetMapping("/")
    public ResponseEntity<Iterable<Article>> listArticles() {

        return ResponseEntity.ok()
                .body(articleDao.findAll());
    }

    // curl -I  http://localhost:8080/api/articles
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Iterable<Article>> getArticleCount() {

        return ResponseEntity.ok()
                .header("Article-Count", String.valueOf(articleDao.count()))
                .body(articleDao.findAll());
    }

    // curl http://localhost:8080/api/articles/2 |jq
    @GetMapping("{ar_id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("ar_id") int id) {

        return articleDao.findById(id)

                // if found by id, return body
                .map(ResponseEntity.ok()::body)

                // else return notFound
                .orElse(ResponseEntity.notFound().build());
    }


    // curl -v -X PUT localhost:8080/api/articles/ -H "Content-Type:application/json" -d "{\"title\":\"New Article\", \"body\":\"New Article Content\"}"
    @PutMapping
    public ResponseEntity addArticle(@RequestBody Article article) {

        articleDao.save(article);
        return ResponseEntity.ok().build();
    }

    // curl -v -X PATCH localhost:8080/api/articles/1 -H "Content-Type:application/json" -d "{\"title\":\"Updated Article\", \"body\":\"Updated Article Content\"}"
    // PatchMapping -> Partially Update
    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateArticle(@PathVariable int id, @RequestBody Article article) {

        if (articleDao.existsById(id)) {
            article.setId(id);
            articleDao.save(article);
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // curl -v -X DELETE http://localhost:8080/api/articles/3
    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteArticleById(@PathVariable int id) {

        if (articleDao.existsById(id)) {
            articleDao.deleteById(id);
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
