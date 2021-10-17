package com.bmarques.springjdbcmapping.api;

import com.bmarques.springjdbcmapping.domain.participant.ParticipantService;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
@RequestMapping("/v1/participants")
public class ParticipantController {

  private final ParticipantService service;
  private final ParticipantMapper mapper;

  public ParticipantController(ParticipantService service, ParticipantMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @CrossOrigin(origins = "http://localhost:8081")
  @GetMapping
  public Mono<List<ParticipantResponse>> getAllParticipants() {
    return Mono.fromCallable(() -> service.getAllParticipants())
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }

  @GetMapping("/{id}")
  public Mono<ParticipantResponse> getParticipantById(@PathVariable UUID id) {
    return Mono.fromCallable(() -> service.getParticipantById(id))
        .map(participant -> mapper
            .toResponse(participant.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Code not found"))))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping
  public Mono<ParticipantResponse> create(@RequestBody ParticipantRequest request) {
    log.info(request.toString());

    return Mono.fromCallable(() -> mapper.toEntity(request))
        .map(service::create)
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }

  @DeleteMapping
  public Mono<Void>
  @PutMapping("/{id}")
  public Mono<ParticipantResponse> update(@PathVariable UUID id,
                                          @RequestBody ParticipantRequest request) {
    return Mono.fromCallable(() -> service.getParticipantById(id))
        .map(participant -> mapper.toEntity(participant.orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Code not found")), request))
        .map(service::create)
        .map(mapper::toResponse)
        .subscribeOn(Schedulers.boundedElastic());
  }
}
