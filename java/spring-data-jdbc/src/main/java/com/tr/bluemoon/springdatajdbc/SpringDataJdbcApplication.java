package com.tr.bluemoon.springdatajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	/*@Bean
	ApplicationRunner applicationRunner(DependentRepository dependentRepository) {
		return args -> {
			Dependent dependent1 = Dependent.create("Ts", 1);
		}
	}*/

}
