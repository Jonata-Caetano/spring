package com.bmarques.springkafkaavroconsumer.merchant;

import com.bmarques.springkafkaavroconsumer.config.EventProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MerchantListener {

    @KafkaListener(topics = EventProperties.MERCHANT_TOPIC, groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: {}", EventProperties.MERCHANT_TOPIC);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());

    }
}