package com.tenpo.spicardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpicardoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpicardoApplication.class, args);
	}
	
	

}
