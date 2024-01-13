  package com.laborator.FootballDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.laborator.FootballDatabase.Domain")
@EnableJpaRepositories(basePackages = "com.*")
@ComponentScan(basePackages = "com.laborator.FootballDatabase.Domain")
@SpringBootApplication

public class FootballDatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(FootballDatabaseApplication.class, args);
    }
}