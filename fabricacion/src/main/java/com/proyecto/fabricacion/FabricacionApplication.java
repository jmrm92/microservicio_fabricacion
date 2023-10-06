package com.proyecto.fabricacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan (basePackages="com.proyecto.fabricacion.model")
@SpringBootApplication(scanBasePackages = {"com.proyecto.fabricacion.controller", "com.proyecto.fabricacion.service"})
public class FabricacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricacionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
