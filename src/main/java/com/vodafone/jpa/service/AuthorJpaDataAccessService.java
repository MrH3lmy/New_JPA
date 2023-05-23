package com.vodafone.jpa.service;

import com.vodafone.jpa.model.Author;
import com.vodafone.jpa.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class AuthorJpaDataAccessService implements AuthorService {

    @Autowired
   private final AuthorRepository authorRepo;

    public AuthorJpaDataAccessService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author getAuthorById(Integer id) {
        Optional<Author> byId = authorRepo.findById(id);

        return byId.orElse(null) ;
    }

    @Override
    public Author addArticle(Author article) {
        return authorRepo.save(article);
    }
}
