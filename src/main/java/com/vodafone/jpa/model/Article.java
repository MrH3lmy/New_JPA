package com.vodafone.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "article_name")
    private String name;
    private String author;
    @Column(name = "auth_id")
    private Integer authorId;
    @OneToMany(mappedBy = "article")
    private List<Links> links;
}
