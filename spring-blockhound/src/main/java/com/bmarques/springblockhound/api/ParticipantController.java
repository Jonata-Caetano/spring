package com.bmarques.springblockhound.api;

import com.bmarques.springblockhound.domain.participant.Participant;
import com.bmarques.springblockhound.domain.participant.ParticipantService;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping("/v1/participant")
public class ParticipantController {

  private final ParticipantService service;
  private final ParticipantMapper mapper;

  public ParticipantController(ParticipantService service, ParticipantMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Mono<List<Participant>> getAllParticipants() {
    service.getAllParticipants();
    return Mono.fromCallable(service::getAllParticipants)
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public Mono<ParticipantResponse> findById(
      @PathVariable UUID id) {

    // The code below is blocking the application and it's a example that should'nt be used.
    //    service.getClientById(id);

    log.info("findById method invoked");
    return Mono.fromCallable(() -> service.getClientById(id))
        .map(client -> client
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found")))
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public Mono<ParticipantResponse> create(
      @RequestBody final ParticipantRequest requestBody) {

    log.info("create method invoked");
    Participant participant = mapper.toEntity(requestBody);
    return service.saveClient(participant)
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PutMapping("/{id}")
  @ResponseStatus(value = HttpStatus.CREATED)
  public Mono<ParticipantResponse> update(
      @PathVariable final UUID id,
      @RequestBody final ParticipantRequest requestBody) {

    log.info("update method invoked");
    return Mono.fromCallable(() -> service.getClientById(id))
        .map(participant -> mapper
            .toEntity(participant.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code not found")), requestBody))
        .flatMap(service::saveClient)
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }
}
