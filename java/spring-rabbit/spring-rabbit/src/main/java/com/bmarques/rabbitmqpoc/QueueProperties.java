package com.bmarques.rabbitmqpoc;

public class QueueProperties {

  public static final String RABBITMQ_EXCHANGE_DEPRECATED =
      "com.bmarques.exchange.rabbitmq-poc";
  public static final String RABBITMQ_RETRY_EXCHANGE_DEPRECATED =
      "com.bmarques.exchange.rabbitmq-poc.retry";
  public static final String RABBITMQ_DEAD_LETTER_EXCHANGE_DEPRECATED =
      "com.bmarques.exchange.rabbitmq-poc.dead-letter";

  public static final String RABBITMQ_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc-new";
  public static final String RABBITMQ_RETRY_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc.retry-new";
  public static final String RABBITMQ_DEAD_LETTER_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc.dead-letter-new";
//  public static final String RABBITMQ_EXCHANGE =
//    "com.bmarques.exchange.rabbitmq-poc";
//  public static final String RABBITMQ_RETRY_EXCHANGE =
//      "com.bmarques.exchange.rabbitmq-poc.retry";
//  public static final String RABBITMQ_DEAD_LETTER_EXCHANGE =
//      "com.bmarques.exchange.rabbitmq-poc.dead-letter";

  public static final String CLIENT_QUEUE_RK_DEPRECATED = "com.bmarques.event.rabbitmq-poc.client";
  public static final String CLIENT_QUEUE_RK = "com.bmarques.event.rabbitmq-poc.client_new";
//  public static final String CLIENT_QUEUE_RK = "com.bmarques.event.rabbitmq-poc.client";

  public static final String CLIENT_QUEUE_DEPRECATED =
      "com.bmarques.subscriber.rabbitmq-poc.client";
  public static final String CLIENT_RETRY_QUEUE_DEPRECATED =
      "com.bmarques.subscriber.rabbitmq-poc.client-retry";
  public static final String CLIENT_DEAD_LETTER_QUEUE_DEPRECATED =
      "com.bmarques.subscriber.rabbitmq-poc.client-dead-letter";
  public static final String CLIENT_QUEUE =
      "com.bmarques.subscriber.rabbitmq-poc.client-new";
  public static final String CLIENT_RETRY_QUEUE =
      "com.bmarques.subscriber.rabbitmq-poc.client-retry-new";
  public static final String CLIENT_DEAD_LETTER_QUEUE =
      "com.bmarques.subscriber.rabbitmq-poc.client-dead-letter-new";

//  public static final String CLIENT_QUEUE =
//      "com.bmarques.subscriber.rabbitmq-poc.client";
//  public static final String CLIENT_RETRY_QUEUE =
//      "com.bmarques.subscriber.rabbitmq-poc.client-retry";
//  public static final String CLIENT_DEAD_LETTER_QUEUE =
//      "com.bmarques.subscriber.rabbitmq-poc.client-dead-letter";

}
