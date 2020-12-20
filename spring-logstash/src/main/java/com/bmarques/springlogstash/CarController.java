package com.bmarques.springlogstash;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping("/car")
public class CarController {

  @GetMapping
  public Mono<Car> getCar() {

    log.debug("Debug: Into getCar method!");
    log.info("Info: Into getCar method!");
    log.trace("Trace: Into getCar method!");
    log.warn("Warn: Into getCar method!");
    log.error("Error: Into getCar method!");

    return Mono.just(Car.builder()
                         .code(1)
                         .description("Fiesta")
                         .trunk("1.0")
                         .build())
        .subscribeOn(Schedulers.boundedElastic());
  }
}
