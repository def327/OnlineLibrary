package com.def327.project.library.application.init;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.def327.project.library.dao.entities"})
@EnableJpaRepositories(basePackages = {"com.def327.project.library.dao.repository"})
@ComponentScan(basePackages = {"com.def327.project.library"})
@EnableAspectJAutoProxy
public class ApplicationRunner extends SpringBootServletInitializer {
}