package com.bmarques.springelk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@EnableReactiveElasticsearchRepositories
@SpringBootApplication
public class SpringElkApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringElkApplication.class, args);
  }
}

