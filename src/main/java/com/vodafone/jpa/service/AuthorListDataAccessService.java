package com.vodafone.jpa.service;

import com.vodafone.jpa.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorListDataAccessService implements AuthorService {
    List<Author> authors = new ArrayList<>();
    Integer id = 0;

    public AuthorListDataAccessService() {
        Author author = new Author();
        author.setId(1);
        author.setName("ahmed");
        authors.add(author);
    }

    @Override
    public Author getAuthorById(Integer id) {
        for (Author author : authors) {
            if (id.equals(author.getId())) {
                return author;
            }
        }
        return null;
    }

    @Override
    public Author addArticle(Author article) {
        return null;
    }
}
