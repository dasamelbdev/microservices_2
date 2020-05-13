package com.microservices.training.basics.name;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceNameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceNameApplication.class, args);
	}

}
