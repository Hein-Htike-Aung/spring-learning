package com.example.todolistdemo.controller;

import com.example.todolistdemo.entity.Article;
import com.example.todolistdemo.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("newArticle", new Article());

        return "index";
    }

    @PostMapping("/save-article")
    public String saveArticle(Article article) {

        articleRepository.save(article);

        return "redirect:/";
    }

    @PostMapping("/delete-article")
    public String deleteArticle(@PathParam("id") int id) {

        articleRepository.deleteById(id);

        return "redirect:/";
    }

}
