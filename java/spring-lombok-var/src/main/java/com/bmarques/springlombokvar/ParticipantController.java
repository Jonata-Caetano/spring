package com.bmarques.springlombokvar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

  @GetMapping
  public Mono<List<ParticipantResponse>> getParticipant() {
    //    List<Participant> participants = Stream
    var participants = Stream
        .of(Participant.builder()
                .code(1)
                .name("Tiago")
                .cpf("066.067.879.98")
                .build(),
            Participant.builder()
                .code(1)
                .name("Nicolas")
                .cpf("705.987.456.12")
                .build())
        .collect(Collectors.toList());

    //    List<ParticipantResponse> participantResponses = participants.stream()
    var participantResponses = participants.stream()
        .map(participant -> ParticipantResponse.builder()
            .id(Long.valueOf(participant.getCode()))
            .fullName(participant.getName())
            .registry(participant.getCpf())
            .build())
        .collect(Collectors.toList());

    return Mono.just(participantResponses)
        .subscribeOn(Schedulers.boundedElastic());
  }
}
