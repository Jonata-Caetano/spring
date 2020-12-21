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

    log.info("Info: Tiago!");

    return Mono.just(Car.builder()
                         .code(1)
                         .description("Fiesta")
                         .trunk("1.0")
                         .build())
        .subscribeOn(Schedulers.boundedElastic());
  }
}
