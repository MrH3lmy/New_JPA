package com.vodafone.jpa.model;

import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;

}
