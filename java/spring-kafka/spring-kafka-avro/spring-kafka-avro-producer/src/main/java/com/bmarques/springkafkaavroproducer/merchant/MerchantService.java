package com.bmarques.springkafkaavroproducer.merchant;

import com.bmarques.springkafkaavroproducer.EventProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MerchantService {

    private List<MerchantEntity> repository = new ArrayList<>();

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MerchantService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<MerchantEntity> findAll() {
        return repository;
    }

    public MerchantEntity save(MerchantEntity entity) {
        log.info("Payload enviado: {}", entity.toString());
        kafkaTemplate.send(EventProperties.MERCHANT_TOPIC, entity.toString());

        repository.add(entity);
        return entity;
    }
}