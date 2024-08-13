package com.gitrepo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RepositoryDetails {
    private String full_name;
    private String description;
    private String clone_url;
    private int stargazers_count;
    private LocalDateTime created_at;

    public RepositoryDetails() {
    }

    public RepositoryDetails(String full_name, String description, String clone_url, int stargazers_count, LocalDateTime created_at) {
        this.full_name = full_name;
        this.description = description;
        this.clone_url = clone_url;
        this.stargazers_count = stargazers_count;
        this.created_at = created_at;
    }

}

