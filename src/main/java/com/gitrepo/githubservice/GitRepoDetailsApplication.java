package com.gitrepo.githubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.gitrepo")
@Configuration
@EnableAutoConfiguration
@EntityScan("com.gitrepo.model")
@EnableJpaRepositories("com.gitrepo.repository")
public class GitRepoDetailsApplication {


	public static void main(String[] args) {
		SpringApplication.run(GitRepoDetailsApplication.class, args);


	}

}
