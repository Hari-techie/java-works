package com.kgisl.VotingManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class VotingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingManagementApplication.class, args);
	}

}
