package com.bmarques.springr2dbc.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<Client, Integer> {

  Mono<Client> findById(int id);
}
