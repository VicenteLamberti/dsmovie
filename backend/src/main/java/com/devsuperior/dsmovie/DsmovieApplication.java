package com.devsuperior.dsmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DsmovieApplication {

	public static void main(String[] args) {

		SpringApplication.run(DsmovieApplication.class, args);
	}

}
