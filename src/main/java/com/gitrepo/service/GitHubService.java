package com.gitrepo.service;

import com.gitrepo.common.Constants;
import com.gitrepo.dto.RepositoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GitHubService {

    @Autowired
    private RestTemplate restTemplate;

    public RepositoryDetails getGitRepositoryDetails(String owner, String repoName) {
        Map<String, String> params = new HashMap<>();
        params.put(Constants.OWNER, owner);
        params.put(Constants.REPO_NAME, repoName);
        return restTemplate.getForObject(Constants.GET_GIT_REPO_URL, RepositoryDetails.class, params);
    }
}
