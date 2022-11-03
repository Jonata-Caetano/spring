package com.bmarques.springrabbitcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({BindingDestinationProperties.class})
public class SpringRabbitCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitCloudApplication.class, args);
	}

}
