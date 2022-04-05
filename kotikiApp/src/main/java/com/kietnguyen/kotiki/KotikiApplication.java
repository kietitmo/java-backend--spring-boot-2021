package com.kietnguyen.kotiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kietnguyen.*"})
@EntityScan(basePackages = {"com.kietnguyen.*"})
@EnableJpaRepositories(basePackages = {"com.kietnguyen.*"})
public class KotikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KotikiApplication.class, args);
	}

}
