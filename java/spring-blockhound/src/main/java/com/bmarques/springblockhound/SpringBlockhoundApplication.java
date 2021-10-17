package com.bmarques.springblockhound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class SpringBlockhoundApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(SpringBlockhoundApplication.class, args);
	}

}
