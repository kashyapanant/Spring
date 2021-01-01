package com.infinity.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.danske.co")
public class OrganizationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationManagementApplication.class, args);
	}

}
