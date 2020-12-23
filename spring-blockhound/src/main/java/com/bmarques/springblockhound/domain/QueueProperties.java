package com.bmarques.springblockhound.domain;

public class QueueProperties {

  public static final String RABBITMQ_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc";
  public static final String RABBITMQ_RETRY_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc.retry";
  public static final String RABBITMQ_DEAD_LETTER_EXCHANGE =
      "com.bmarques.exchange.rabbitmq-poc.dead-letter";

    public static final String CLIENT_QUEUE_RK = "com.bmarques.event.rabbitmq-poc.client";

    public static final String CLIENT_QUEUE =
        "com.bmarques.subscriber.rabbitmq-poc.client";
    public static final String CLIENT_RETRY_QUEUE =
        "com.bmarques.subscriber.rabbitmq-poc.client-retry";
    public static final String CLIENT_DEAD_LETTER_QUEUE =
        "com.bmarques.subscriber.rabbitmq-poc.client-dead-letter";
}
