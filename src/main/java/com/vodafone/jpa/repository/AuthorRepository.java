package com.vodafone.jpa.repository;

import com.vodafone.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author,Integer> , JpaRepository<Author,Integer> {

}
