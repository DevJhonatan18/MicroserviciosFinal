package com.bardalez.microcursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicrocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocursosApplication.class, args);
	}

}
