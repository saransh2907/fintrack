package com.trackfin.fintrack;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FintrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintrackApplication.class, args);
	}

	@Value("${spring.application.name}")
	private String appName;

	@PostConstruct
	public void printAppName() {
		System.out.println("App Name: " + appName);
	}
}
