package com.gitrepo.service;

import com.gitrepo.dto.RepositoryDetails;
import com.gitrepo.githubservice.GitRepoDetailsApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootTest(classes = {GitRepoDetailsApplication.class})
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class GitHubServiceTest {

    @InjectMocks
    private GitHubService gitHubService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void getGitRepositoryDetailsTest() throws Exception {
        RepositoryDetails mockResponse = new RepositoryDetails();
        mockResponse.setFull_name("full/name");
        mockResponse.setDescription("description");
        mockResponse.setClone_url("http://clone.url");
        mockResponse.setStargazers_count(100);
        mockResponse.setCreated_at(LocalDateTime.now());
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(RepositoryDetails.class), Mockito.anyMap())).thenReturn(mockResponse);

        RepositoryDetails details = gitHubService.getGitRepositoryDetails("owner","repoName");

        Assertions.assertEquals(details, mockResponse);
    }
}
