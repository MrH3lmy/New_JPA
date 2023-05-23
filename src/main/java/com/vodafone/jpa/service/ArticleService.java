package com.vodafone.jpa.service;


import com.vodafone.jpa.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(Integer id);
    List<Article> getArticlesByAuthorName(String authorName);
    Article addArticle(Article article);

    void deleteArticle(Integer id);

    Article updateArticle(Integer id, Article article);
}
