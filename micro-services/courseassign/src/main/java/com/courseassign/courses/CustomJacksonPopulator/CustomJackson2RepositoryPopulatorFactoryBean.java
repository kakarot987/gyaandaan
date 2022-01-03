package com.courseassign.courses.CustomJacksonPopulator;

import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.ResourceReader;

public class CustomJackson2RepositoryPopulatorFactoryBean extends Jackson2RepositoryPopulatorFactoryBean {
    @Override
    protected ResourceReader getResourceReader() {
        return new CustomJackson2ResourceReader();
    }
}