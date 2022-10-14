package com.bmarques.rabbitmqpoc.util;

import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_DEAD_LETTER_QUEUE_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_QUEUE_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_QUEUE_RK_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_RETRY_QUEUE_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_EXCHANGE_DEPRECATED;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_RETRY_EXCHANGE_DEPRECATED;
import static reactor.rabbitmq.BindingSpecification.binding;
import static reactor.rabbitmq.ExchangeSpecification.exchange;
import static reactor.rabbitmq.QueueSpecification.queue;

import com.rabbitmq.client.AMQP.Exchange.DeclareOk;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.AMQP.Queue.BindOk;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Sender;

public class RabbitMQConfigDeprecated {

  private static final String EXCHANGE_TYPE = "topic";
  private static final String DEAD_LETTER_EXCHANGE_HEADER = "x-dead-letter-exchange";
  private static final String MESSAGE_TIME_TO_LIVE_HEADER = "x-message-ttl";
  private static final int MESSAGE_TIME_TO_LIVE = (int) TimeUnit.MINUTES.toMillis(1);

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Mono<BindOk> generateDeclaration(Sender sender) {

    //Exchanges declarations
    Mono<DeclareOk> exchangeDeclaration = sender
        .declareExchange(exchange(RABBITMQ_EXCHANGE_DEPRECATED).type(EXCHANGE_TYPE).durable(true))
        .then(sender.declareExchange(exchange(RABBITMQ_RETRY_EXCHANGE_DEPRECATED)
                                         .type(EXCHANGE_TYPE).durable(true)))
        .then(sender.declareExchange(exchange(RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED)
                                         .type(EXCHANGE_TYPE).durable(true)));

    //Queues declarations
    Mono<Queue.DeclareOk> declareQueue =
        sender.declareQueue(queue(CLIENT_QUEUE_DEPRECATED).durable(true)
                                .arguments(
                                    Collections
                                        .singletonMap(
                                            DEAD_LETTER_EXCHANGE_HEADER,
                                            RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED)
                                          ))
            .then(sender.declareQueue(queue(CLIENT_DEAD_LETTER_QUEUE_DEPRECATED).durable(true)))
            .then(sender.declareQueue(queue(CLIENT_RETRY_QUEUE_DEPRECATED).durable(true)
                                          .arguments(
                                              Stream.of(
                                                  Pair.of(DEAD_LETTER_EXCHANGE_HEADER,
                                                          RABBITMQ_EXCHANGE_DEPRECATED),
                                                  Pair.of(MESSAGE_TIME_TO_LIVE_HEADER,
                                                          MESSAGE_TIME_TO_LIVE)
                                                       )
                                                  .collect(
                                                      Collectors
                                                          .toMap(Pair::getFirst, Pair::getSecond))
                                                    )));

    //Bind declarations
    Mono<BindOk> defineBind = sender
        .bind(binding(RABBITMQ_EXCHANGE_DEPRECATED, CLIENT_QUEUE_RK_DEPRECATED,
                      CLIENT_QUEUE_DEPRECATED))
        .then(sender.bind(
            binding(RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED, CLIENT_QUEUE_RK_DEPRECATED,
                    CLIENT_DEAD_LETTER_QUEUE_DEPRECATED)))
        .then(sender.bind(binding(RABBITMQ_RETRY_EXCHANGE_DEPRECATED, CLIENT_QUEUE_RK_DEPRECATED,
                                  CLIENT_RETRY_QUEUE_DEPRECATED)));

    //Gathers all declarations
    return exchangeDeclaration
        .then(declareQueue)
        .then(defineBind)
        .doOnSuccess(r -> {
                       logger.info("Declarations below are deprecated");
                       logger.info("Queue {} created", CLIENT_QUEUE_DEPRECATED);
                       logger.info("Queue {} created", CLIENT_DEAD_LETTER_QUEUE_DEPRECATED);
                       logger.info("Queue {} created", CLIENT_RETRY_QUEUE_DEPRECATED);
                       logger
                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_EXCHANGE_DEPRECATED,
                                 CLIENT_QUEUE_DEPRECATED,
                                 CLIENT_QUEUE_RK_DEPRECATED);
                       logger

                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED,
                                 CLIENT_DEAD_LETTER_QUEUE_DEPRECATED,
                                 CLIENT_QUEUE_RK_DEPRECATED);
                       logger
                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_RETRY_EXCHANGE_DEPRECATED,
                                 CLIENT_RETRY_QUEUE_DEPRECATED,
                                 CLIENT_QUEUE_RK_DEPRECATED);
                       logger.info("Declarations deprecated finished.");
                     }
                    )
        .doOnError(
            e -> logger.error("Error while trying to declare exchanges, queues and bindings", e));
  }
}
