package com.bmarques.springkafkaavroproducer.merchant;

import com.bmarques.springkafkaavroproducer.config.EventProperties;
import com.bmarques.springkafkaavroproducer.Merchant;
import com.bmarques.springkafkaavroproducer.config.KafkaPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MerchantService {

    private List<MerchantEntity> repository = new ArrayList<>();

    private final KafkaPublisher kafkaPublisher;

    public MerchantService(KafkaPublisher kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
    }

    public List<MerchantEntity> findAll() {
        return repository;
    }

    public MerchantEntity save(MerchantEntity entity) {
        log.info("Payload enviado: {}", entity.toString());

        // Send Avro Class to Kafka
        Merchant merchant = new Merchant();
        merchant.setID(entity.getId().toString());
        merchant.setNAME(entity.getName());

        this.kafkaPublisher.sendMessage(merchant, entity.getId().toString(), EventProperties.MERCHANT_TOPIC);
        repository.add(entity);
        return entity;
    }
}