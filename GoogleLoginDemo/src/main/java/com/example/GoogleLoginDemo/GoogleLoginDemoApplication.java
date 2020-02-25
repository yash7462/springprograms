package com.example.GoogleLoginDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.GoogleLoginDemo")

public class GoogleLoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleLoginDemoApplication.class, args);
	}

}
