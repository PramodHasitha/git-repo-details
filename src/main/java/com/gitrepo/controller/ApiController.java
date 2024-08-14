package com.gitrepo.controller;

import com.gitrepo.dto.RepositoryDetails;
import com.gitrepo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
public class ApiController {
    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/{owner}/{repoName}")
    public ResponseEntity<RepositoryDetails> getRepositoryDetails(
            @PathVariable String owner, @PathVariable String repoName) {
        RepositoryDetails details = repositoryService.getRepositoryDetails(owner, repoName);
        return ResponseEntity.ok(details);
    }
}
