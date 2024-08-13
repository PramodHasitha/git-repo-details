package com.gitrepo.repository;

import com.gitrepo.model.RepositoryDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryDetailsRepository extends JpaRepository<RepositoryDetailsEntity, Long> {
    Optional<RepositoryDetailsEntity> findByOwnerAndRepoName(String owner, String repoName);
}
