package com.gitrepo.git_repo_details;

import com.gitrepo.dto.RepositoryDetails;
import com.gitrepo.githubservice.GitRepoDetailsApplication;
import com.gitrepo.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GitRepoDetailsApplication.class})
@AutoConfigureMockMvc
class GitRepoDetailsApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RepositoryService repositoryService;

	@Mock
	private RestTemplate restTemplate;

	@Test
	void getRepositoryDetailsTest() throws Exception {
		RepositoryDetails mockResponse = new RepositoryDetails();
		mockResponse.setFull_name("full/name");
		mockResponse.setDescription("description");
		mockResponse.setClone_url("http://clone.url");
		mockResponse.setStargazers_count(100);
		mockResponse.setCreated_at(LocalDateTime.now());
		Mockito.when(repositoryService.getRepositoryDetails(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(mockResponse);

		mockMvc.perform(MockMvcRequestBuilders.get("/repositories/owner/repoName"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("full/name"));
	}



	@Test
	void getRepositoryDetailsTest1() throws Exception {
		RepositoryDetails mockResponse = new RepositoryDetails();
		mockResponse.setFull_name("full/name");
		mockResponse.setDescription("description");
		mockResponse.setClone_url("http://clone.url");
		mockResponse.setStargazers_count(100);
		mockResponse.setCreated_at(LocalDateTime.now());
//		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(RepositoryDetails.class), Mockito.anyMap())).thenReturn(mockResponse);

		mockMvc.perform(MockMvcRequestBuilders.get("/repositories/owner/repoName"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.full_name").value("full/name"));
	}

}
