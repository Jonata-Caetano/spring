package com.bmarques.springkafkaavroproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SpringKafkaAvroProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaAvroProducerApplication.class, args);
	}

}
