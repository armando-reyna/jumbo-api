package com.jumbo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class RepositoryAutoPopulator {

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
        final Resource sourceData = new ClassPathResource("store-data.json");
        final Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[]{sourceData});
        return factory;
    }

}
