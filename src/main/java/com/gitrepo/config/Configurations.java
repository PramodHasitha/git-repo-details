package com.gitrepo.config;

import com.gitrepo.exception.handler.RestTemplateErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@EnableCaching
public class Configurations {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate template = builder.build();
        template.setErrorHandler(new RestTemplateErrorHandler());
        return template;
    }


    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("repositories");
    }
}
