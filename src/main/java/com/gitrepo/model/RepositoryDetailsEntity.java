package com.gitrepo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class RepositoryDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String repoName;
    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars;
    private LocalDateTime createdAt;


    public RepositoryDetailsEntity(String owner, String repoName, String fullName, String description, String cloneUrl, int stars, LocalDateTime createdAt) {
        this.owner = owner;
        this.repoName = repoName;
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }
}

