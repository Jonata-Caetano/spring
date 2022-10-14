package com.bmarques.rabbitmqpoc.controller;

import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_QUEUE_RK;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_DEAD_LETTER_EXCHANGE;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_EXCHANGE;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_RETRY_EXCHANGE;

import com.bmarques.rabbitmqpoc.util.BasePublisher;
import com.bmarques.rabbitmqpoc.util.MessageBodyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/publisher-message")
public class RabbitMQPublisherController {

  @Autowired
  private BasePublisher basePublisher;

  @PostMapping
  public Mono<String> publishMessage(@RequestBody MessageBodyDto messageBodyDto) {
    return basePublisher.sendMessageToPublisher(messageBodyDto, RABBITMQ_EXCHANGE, CLIENT_QUEUE_RK)
        .single()
        .thenReturn("Message published successfully!")
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping("/retry")
  public Mono<String> publishMessageRetry(@RequestBody MessageBodyDto messageBodyDto) {
    return basePublisher.sendMessageToPublisher(messageBodyDto, RABBITMQ_RETRY_EXCHANGE, CLIENT_QUEUE_RK)
        .single()
        .thenReturn("Message published successfully!")
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping("/dead-letter")
  public Mono<String> publishMessageDeadLetter(@RequestBody MessageBodyDto messageBodyDto) {
    return basePublisher.sendMessageToPublisher(messageBodyDto, RABBITMQ_DEAD_LETTER_EXCHANGE, CLIENT_QUEUE_RK)
        .single()
        .thenReturn("Message published successfully!")
        .subscribeOn(Schedulers.boundedElastic());
  }
}
