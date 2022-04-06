package com.bmarques.springkakaproducer.merchant.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String record, String id, String topic) {
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topic, id, record);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable e) {
                log.error("m=sendMessage, result=false, topic={}, id={}, message={}", topic, id, e.getMessage(), e);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("m=sendMessage, result=true, topic={}, id={}, offset={}, partition={}", topic, id, result.getRecordMetadata().offset(),
                        result.getRecordMetadata().partition());
                log.trace("m=sendMessage, result=true, record={}", record);
            }
        });
    }
}