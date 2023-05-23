package com.vodafone.jpa.service;


import com.vodafone.jpa.model.Author;

public interface AuthorService {
    Author getAuthorById(Integer id);
    Author addArticle(Author article);

}
