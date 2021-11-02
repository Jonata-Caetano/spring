package com.bmarques.springkafkaavroproducer.helloworld;

import com.bmarques.springkafkaavroproducer.EventProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloWorldService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public HelloWorldService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String getMessage(String message) {
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(EventProperties.GREETINGS_TOPIC, message);

        return "Success";
    }
}
