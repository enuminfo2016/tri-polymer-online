package com.enuminfo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TriPolymer Online", 
	version = "0.0.1-SNAPSHOT", 
	description = "ENUMInfo | Spring Cloud MicroService - Tri Polymer Online Service"))
public class TriPolymerOnlineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TriPolymerOnlineApplication.class, args);
	}
}
