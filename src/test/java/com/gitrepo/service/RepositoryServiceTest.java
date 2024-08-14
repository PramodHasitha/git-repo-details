package com.gitrepo.service;


import com.gitrepo.dto.RepositoryDetails;
import com.gitrepo.githubservice.GitRepoDetailsApplication;
import com.gitrepo.repository.RepositoryDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest(classes = {GitRepoDetailsApplication.class})
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class RepositoryServiceTest {

    @InjectMocks
    private RepositoryService repositoryService;

    @Mock
    private GitHubService gitHubService;

    @Mock
    private RepositoryDetailsRepository repositoryRepository;

    @Test
    void getRepositoryDetails() throws Exception {
        RepositoryDetails mockResponse = new RepositoryDetails();
        mockResponse.setFull_name("full/name");
        mockResponse.setDescription("description");
        mockResponse.setClone_url("http://clone.url");
        mockResponse.setStargazers_count(100);
        mockResponse.setCreated_at(LocalDateTime.now());
        Mockito.when(gitHubService.getGitRepositoryDetails(Mockito.anyString(), Mockito.anyString())).thenReturn(mockResponse);
        Mockito.when(repositoryRepository.findByOwnerAndRepoName(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.empty());

        RepositoryDetails details = repositoryService.getRepositoryDetails("owner","repoName");

        Assertions.assertEquals(details.getFull_name(), mockResponse.getFull_name());
        Assertions.assertEquals(details.getDescription(), mockResponse.getDescription());
        Assertions.assertEquals(details.getClone_url(), mockResponse.getClone_url());
    }
}
