package com.appleindustries.c2.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.appleindustries.c2.service", "com.appleindustries.c2.repository"})
@ComponentScan(basePackages = "com.appleindustries.c2.service")
@EnableJpaRepositories("com.appleindustries.c2.repository")
@EntityScan("com.appleindustries.c2.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
