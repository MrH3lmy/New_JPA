package com.vodafone.jpa.repository;

import com.vodafone.jpa.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article,Integer> , JpaRepository<Article,Integer> {  // pagination
    List<Article> findByName(String authorName);
    @Query("SELECT a FROM Article a WHERE a.id = :id")
    Article findArticleById(@Param("id") Integer id);



}
