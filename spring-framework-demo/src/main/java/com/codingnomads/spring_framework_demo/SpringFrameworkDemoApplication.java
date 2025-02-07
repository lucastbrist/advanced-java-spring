package com.codingnomads.spring_framework_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFrameworkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkDemoApplication.class, args);
		System.out.println("Hello CodingNomads!");
	}

}
