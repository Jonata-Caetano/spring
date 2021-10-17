package com.bmarques.springblockhound.api;

import com.bmarques.springblockhound.domain.participant.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

  public ParticipantResponse toResponse(Participant participant) {
    return ParticipantResponse.builder()
        .id(participant.getId())
        .code(participant.getCode())
        .name(participant.getName())
        .build();
  }

  public Participant toEntity(ParticipantRequest requestBody) {
    return Participant.builder()
        .code(requestBody.getCode())
        .name(requestBody.getName())
        .build();
  }

  public Participant toEntity(Participant participant, ParticipantRequest requestBody) {
    return Participant.builder()
        .id(participant.getId())
        .code(requestBody.getCode())
        .name(requestBody.getName())
        .build();
  }
}
