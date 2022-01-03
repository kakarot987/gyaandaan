package com.courseassign;

import com.courseassign.courses.CustomJacksonPopulator.CustomJackson2RepositoryPopulatorFactoryBean;
import com.courseassign.courses.Repository.StudentCourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.AbstractRepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
@EnableEurekaClient
public class CourseassignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseassignApplication.class, args);
	}

	@Bean
	public AbstractRepositoryPopulatorFactoryBean repositoryPopulator(ObjectMapper objectMapper,
																	  StudentCourseRepository studentCourseRepository){
		Jackson2RepositoryPopulatorFactoryBean factoryBean = new CustomJackson2RepositoryPopulatorFactoryBean();
		factoryBean.setMapper(objectMapper);
		factoryBean.setResources(new Resource[]{new ClassPathResource("studentcourse.json"),
				new ClassPathResource("subjectSyllabus.json")});
		return factoryBean;
	}
}
