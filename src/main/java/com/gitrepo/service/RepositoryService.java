package com.gitrepo.service;

import com.gitrepo.dto.RepositoryDetails;
import com.gitrepo.model.RepositoryDetailsEntity;
import com.gitrepo.repository.RepositoryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {
    @Autowired
    private GitHubService gitHubService;

    @Autowired
    private RepositoryDetailsRepository repositoryRepository;

    @Cacheable(value = "repositories", key = "#owner + '/' + #repoName")
    public RepositoryDetails getRepositoryDetails(String owner, String repoName) {
        RepositoryDetailsEntity repositoryDetailsEntity =  repositoryRepository.findByOwnerAndRepoName(owner, repoName)
                .orElseGet(() -> {
                    RepositoryDetails details = gitHubService.getGitRepositoryDetails(owner, repoName);
                    RepositoryDetailsEntity entity = convertToEntity(owner, repoName, details);
                    repositoryRepository.save(entity);
                    return entity;
                });

        return convertToDto(repositoryDetailsEntity);
    }

    private RepositoryDetailsEntity convertToEntity(String owner, String repoName, RepositoryDetails details) {
        return new RepositoryDetailsEntity(owner, repoName, details.getFull_name(), details.getDescription(),
                details.getClone_url(), details.getStargazers_count(), details.getCreated_at());
    }

    private RepositoryDetails convertToDto(RepositoryDetailsEntity details) {
        return new RepositoryDetails(details.getFullName(), details.getDescription(),
                details.getCloneUrl(), details.getStars(), details.getCreatedAt());
    }
}

