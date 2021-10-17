package com.bmarques.springredis;

import io.lettuce.core.api.reactive.RedisReactiveCommands;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class RedisConfig {
//
//  @Bean
//  public RedisConnection redisConnection() {
//    return new RedisConnection(System.getProperty("RedisHost"), System.getProperty("RedisPort"));
//  }
//
//  @Bean
//  public RedisReactiveCommands<String, String> reactiveCommands() {
//    return redisConnection().get().reactive();
//  }
//
//  @PreDestroy
//  public void closeConnection() {
//    redisConnection().stop();
//  }
//}