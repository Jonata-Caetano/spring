package com.bmarques.springkakaproducer.merchant.domain;

import com.bmarques.springkakaproducer.merchant.config.EventProperties;
import com.bmarques.springkakaproducer.merchant.config.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository repository;

    @Autowired
    private KafkaPublisher kafkaPublisher;

    public List<MerchantEntity> findAll() {
        return repository.findAll();
    }

    public MerchantEntity save(MerchantEntity entity) {
        entity.setId(UUID.randomUUID());

        publishMerchantInKafka(entity);

        return repository.save(entity);
    }

    private void publishMerchantInKafka(MerchantEntity entity) {

        this.kafkaPublisher.sendMessage(entity.toString(), entity.getId().toString(), EventProperties.MERCHANT_TOPIC);
    }
}