package com.bmarques.rabbitmqpoc.util;

import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_DEAD_LETTER_QUEUE;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_QUEUE;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_QUEUE_RK;
import static com.bmarques.rabbitmqpoc.QueueProperties.CLIENT_RETRY_QUEUE;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_DEAD_LETTER_EXCHANGE;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_EXCHANGE;
import static com.bmarques.rabbitmqpoc.QueueProperties.RABBITMQ_RETRY_EXCHANGE;
import static reactor.rabbitmq.BindingSpecification.binding;
import static reactor.rabbitmq.ExchangeSpecification.exchange;
import static reactor.rabbitmq.QueueSpecification.queue;

import com.rabbitmq.client.AMQP.Exchange.DeclareOk;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.AMQP.Queue.BindOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.util.Pair;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.RabbitFluxException;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;
import reactor.rabbitmq.Sender;
import reactor.rabbitmq.SenderOptions;

@Configuration
public class RabbitMQConfig {

  private static final String EXCHANGE_TYPE = "topic";
  private static final String DEAD_LETTER_EXCHANGE_HEADER = "x-dead-letter-exchange";
  private static final String MESSAGE_TIME_TO_LIVE_HEADER = "x-message-ttl";
  private static final int MESSAGE_TIME_TO_LIVE = (int) TimeUnit.MINUTES.toMillis(1);

  public static final String INSTANCE_NAME = "instanceName";
  public static final String RABBITMQ_SERVICES = "StartTemplate";

  @Value("${RabbitMQHostName}")
  private String hostName;
  @Value("${RabbitMQUserName}")
  private String userName;
  @Value("${RabbitMQPassword}")
  private String password;
  @Value("${RabbitMQPort}")
  private String port;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Mono<Connection> connectionMono;

  @Bean
  public Mono<Connection> connection() {

    final String connectionName = Optional.ofNullable(System.getProperty(INSTANCE_NAME))
        .orElse(RABBITMQ_SERVICES);

    return Mono.fromCallable(() -> createConnectionFactory().newConnection(connectionName))
        .doOnError(ex -> logger.error("RabbitMQ connection error.", ex))
        .doOnSuccess(
            s -> logger.info("RabbitMQ connection successfully !!"))
        .cache();
  }

  protected ConnectionFactory createConnectionFactory() {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.useNio();
    connectionFactory.setAutomaticRecoveryEnabled(true);
    connectionFactory.setHost(hostName);
    connectionFactory.setPort(Integer.parseInt(port));
    connectionFactory.setUsername(userName);
    connectionFactory.setPassword(password);

    return connectionFactory;
  }

  @Bean(name = "sender")
  public Sender sender(Mono<Connection> connectionMono) {
    Mono<Channel> channelMono = connectionMono.map(c -> {
      try {
        return c.createChannel();
      } catch (Exception e) {
        throw new RabbitFluxException(e);
      }
    }).cache();

    Sender sender = RabbitFlux.createSender(
        new SenderOptions()
            .connectionMono(connectionMono)
            .resourceManagementChannelMono(channelMono)
            .resourceManagementScheduler(Schedulers.boundedElastic()));

    //Exchanges declarations
    Mono<DeclareOk> exchangeDeclaration = sender
        .declareExchange(exchange(RABBITMQ_EXCHANGE).type(EXCHANGE_TYPE).durable(true))
        .then(sender.declareExchange(exchange(RABBITMQ_RETRY_EXCHANGE)
                                         .type(EXCHANGE_TYPE).durable(true)))
        .then(sender.declareExchange(exchange(RABBITMQ_DEAD_LETTER_EXCHANGE)
                                         .type(EXCHANGE_TYPE).durable(true)));

    //Queues declarations
    Mono<Queue.DeclareOk> declareQueue = sender.declareQueue(queue(CLIENT_QUEUE).durable(true)
                                                                 .arguments(
                                                                     Collections
                                                                         .singletonMap(
                                                                             DEAD_LETTER_EXCHANGE_HEADER,
                                                                             RABBITMQ_DEAD_LETTER_EXCHANGE)
                                                                           ))
        .then(sender.declareQueue(queue(CLIENT_DEAD_LETTER_QUEUE).durable(true)))
        .then(sender.declareQueue(queue(CLIENT_RETRY_QUEUE).durable(true)
                                      .arguments(
                                          Stream.of(
                                              Pair.of(DEAD_LETTER_EXCHANGE_HEADER,
                                                      RABBITMQ_EXCHANGE),
                                              Pair.of(MESSAGE_TIME_TO_LIVE_HEADER,
                                                      MESSAGE_TIME_TO_LIVE)
                                                   )
                                              .collect(
                                                  Collectors.toMap(Pair::getFirst, Pair::getSecond))
                                                )));

    //Bind declarations
    Mono<BindOk> defineBind = sender.bind(binding(RABBITMQ_EXCHANGE, CLIENT_QUEUE_RK,
                                                  CLIENT_QUEUE))
        .then(sender.bind(binding(RABBITMQ_DEAD_LETTER_EXCHANGE, CLIENT_QUEUE_RK,
                                  CLIENT_DEAD_LETTER_QUEUE)))
        .then(sender.bind(binding(RABBITMQ_RETRY_EXCHANGE, CLIENT_QUEUE_RK,
                                  CLIENT_RETRY_QUEUE)));

    //Gathers all declarations
    exchangeDeclaration
        .then(declareQueue)
        .then(defineBind)
        .then(new RabbitMQConfigDeprecated().generateDeclaration(sender))
        .doOnSuccess(r -> {
                       logger.info("Queue {} created", CLIENT_QUEUE);
                       logger.info("Queue {} created", CLIENT_DEAD_LETTER_QUEUE);
                       logger.info("Queue {} created", CLIENT_RETRY_QUEUE);
                       logger
                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_EXCHANGE,
                                 CLIENT_QUEUE,
                                 CLIENT_QUEUE_RK);
                       logger

                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_DEAD_LETTER_EXCHANGE,
                                 CLIENT_DEAD_LETTER_QUEUE,
                                 CLIENT_QUEUE_RK);
                       logger
                           .info("Exchange {} created and bound to queue {} with rk {}",
                                 RABBITMQ_RETRY_EXCHANGE,
                                 CLIENT_RETRY_QUEUE,
                                 CLIENT_QUEUE_RK);
                     }
                    )
        .doOnError(
            e -> logger.error("Error while trying to declare exchanges, queues and bindings", e))
        .block();

    return sender;
  }

  @Bean
  @DependsOn({"sender"})
  public Receiver receiver(Mono<Connection> connectionMono) {
    return RabbitFlux.createReceiver(
        new ReceiverOptions()
            .connectionMono(connectionMono));
  }

  @PreDestroy
  public void close() {
    if (connectionMono != null) {
      try {
        connectionMono.block().close();
      } catch (NullPointerException | IOException e) {
        logger.error("Error closing RabbitMQ connection.", e);
      }
    }
  }

}
