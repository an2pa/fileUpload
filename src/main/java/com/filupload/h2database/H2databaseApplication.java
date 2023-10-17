package com.filupload.h2database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.filupload.h2database.POJO")
public class H2databaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2databaseApplication.class, args);
	}

}
