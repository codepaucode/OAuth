package com.mynt.MovieProjectApiPauGonzales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@EnableGlobalAuthentication
@SpringBootApplication
public class MovieProjectApiPauGonzalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProjectApiPauGonzalesApplication.class, args);
	}

}
