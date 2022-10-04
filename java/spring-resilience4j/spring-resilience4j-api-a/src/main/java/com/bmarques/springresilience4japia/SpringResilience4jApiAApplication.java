package com.bmarques.springresilience4japia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringResilience4jApiAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringResilience4jApiAApplication.class, args);
	}

}
