package com.jsp.librarymanagementsystemspringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SpringDocConfiguration {

	@Bean
	public OpenAPI baseOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
				.title("SpringDoc")
				.version("1.0.0")
				.description("mera project hai"));
	}
}
