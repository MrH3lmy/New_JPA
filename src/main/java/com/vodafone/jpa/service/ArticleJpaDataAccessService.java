package com.vodafone.jpa.service;

import com.vodafone.jpa.contoller.ArticlesController;
import com.vodafone.jpa.contoller.AuthorController;
import com.vodafone.jpa.exception.DuplicateException;
import com.vodafone.jpa.exception.NotFoundException;
import com.vodafone.jpa.model.Article;
import com.vodafone.jpa.model.Links;
import com.vodafone.jpa.repository.ArticleRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Primary
public class ArticleJpaDataAccessService implements ArticleService {
    //@Autowired
    private final ArticleRepository articleRepo;

    public ArticleJpaDataAccessService(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> article1 = new ArrayList<>();
        Page<Article> page = articleRepo.findAll(PageRequest.of(0, 5));
        for (Article article : page.getContent()) {
            article1.add(addLinks(article));
        }

        return article1;
    }


    @Override
    public Article getArticleById(Integer id) {
        Optional<Article> byId = articleRepo.findById(id);
        Article article = byId.orElseThrow(() -> new NotFoundException("Article not found"));

        return addLinks(article);
    }

    @Override
    public List<Article> getArticlesByAuthorName(String authorName) {
        List<Article> articles = articleRepo.findByName(authorName);
        if (articles.isEmpty()) {
            throw new NotFoundException("No articles found for author: " + authorName);
        }

        return articles;
    }

    @Override
    public Article addArticle(Article article) {
        // Check if article with the same name already exists
        List<Article> existingArticles = articleRepo.findByName(article.getName());
        if (!existingArticles.isEmpty()) {
            throw new DuplicateException("Article already exists with the same name");
        }

        Article savedArticle = articleRepo.save(article);
        return addLinks(savedArticle);
    }


    @Override
    public void deleteArticle(Integer id) {
        if (!articleRepo.existsById(id)) {
            throw new NotFoundException("Article not found");
        }
        articleRepo.deleteById(id);
    }


    @Override
    public Article updateArticle(Integer id, Article article) {
        if (!articleRepo.existsById(id)) {
            throw new NotFoundException("Article not found");
        }

        article.setId(id);
        articleRepo.save(article);

        return addLinks(article);
    }


    private Article addLinks(Article article){
        List<Links> links = new ArrayList<>();
        Links self = new Links();

        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(ArticlesController.class)
                .getArticle(article.getId())).withRel("self");

        self.setRel("self");
        self.setHref(selfLink.getHref());

        Links authorLink = new Links();
        Link authLink = linkTo(methodOn(AuthorController.class)
                .getAuthorById(article.getAuthorId())).withRel("author");
        authorLink.setRel("author");
        authorLink.setHref(authLink.getHref());

        links.add(self);
        links.add(authorLink);
        article.setLinks(links);
        return article;
    }

}
