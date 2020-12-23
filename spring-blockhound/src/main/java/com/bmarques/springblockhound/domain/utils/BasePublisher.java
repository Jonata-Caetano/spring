package com.bmarques.springblockhound.domain.utils;

import com.bmarques.springblockhound.domain.participant.Participant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import java.nio.charset.Charset;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.OutboundMessageResult;
import reactor.rabbitmq.SendOptions;
import reactor.rabbitmq.Sender;

@Component
public class BasePublisher {

  private static final int PERSISTENT_DELIVERY_MODE = 2;

  private final ObjectMapper objectMapper;
  private final Sender sender;

  public BasePublisher(ObjectMapper objectMapper,
                       Sender sender) {
    this.objectMapper = objectMapper;
    this.sender = sender;
  }

  public Flux<OutboundMessageResult> sendMessageToPublisher(final Participant participant,
                                                            final String exchange,
                                                            final String routingKey) {

    final AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder()
        .deliveryMode(PERSISTENT_DELIVERY_MODE)
        .build();

    String body;
    try {
      body = objectMapper.writeValueAsString(participant);
    } catch (JsonProcessingException e) {
      return Flux.error(new RuntimeException("Valid JSON string not supplied", e));
    }

    Mono<OutboundMessage> outboundMessage = Mono
        .just(new OutboundMessage(exchange, routingKey, basicProperties, body.getBytes(Charset
                                                                                           .defaultCharset())));

    return sender.sendWithPublishConfirms(outboundMessage, new SendOptions().trackReturned(true));
  }
}
