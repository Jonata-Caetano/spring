package com.bmarques.springjdbcmapping.api;

import com.bmarques.springjdbcmapping.domain.participant.Participant;
import com.bmarques.springjdbcmapping.domain.participant.ParticipantPeriodEffect;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

  public List<ParticipantResponse> toResponse(List<Participant> participants) {
    return participants.stream()
        .map(this::toResponse)
        .collect(Collectors.toList());
  }

  public ParticipantResponse toResponse(Participant participant) {
    return ParticipantResponse.builder()
        .id(participant.getId())
        .companyId(participant.getCompanyId())
        .registrationCode(participant.getRegistrationCode())
        .name(participant.getName())
        .registrationType(participant.getRegistrationType())
        .registrationNumber(participant.getRegistrationNumber())
        .build();
  }

  public Participant toEntity(ParticipantRequest request) {
    return Participant.builder()
        .isNew(true)
        .companyId(request.getCompanyId())
        .registrationCode(request.getRegistrationCode())
        .name(request.getName())
        .registrationType(request.getRegistrationType())
        .registrationNumber(request.getRegistrationNumber())
        .participantPeriodEffect(getParticipantPeriodoEffectList(request))
        .build();
  }

  private Set<ParticipantPeriodEffect> getParticipantPeriodoEffectList(ParticipantRequest request) {
    return request.getParticipantPeriodEffect()
        .stream()
        .map(periodEffectRequest ->
                 ParticipantPeriodEffect.builder()
                     .isNew(true)
                     .companyId(request.getCompanyId())
                     .startDate(periodEffectRequest.getStartDate())
                     .name(periodEffectRequest.getName())
                     .legalName(periodEffectRequest.getLegalName())
                     .countingBasis(periodEffectRequest.getCountingBasis())
                     .companySize(periodEffectRequest.getCompanySize())
                     .legalNature(periodEffectRequest.getLegalNature())
                     .mainCnae(periodEffectRequest.getMainCnae())
                     .stateInscription(periodEffectRequest.getStateInscription())
                     .municipalInscription(periodEffectRequest.getMunicipalInscription())
                     .suframaInscription(periodEffectRequest.getSuframaInscription())
                     .build()
            )
        .collect(Collectors.toSet());
  }

  public Participant toEntity(Participant entity, ParticipantRequest request) {
    return Participant.builder()
        .isNew(false)
        .id(entity.getId())
        .createDate(entity.getCreateDate())
        .createdByContactId(entity.getCreatedByContactId())
        .companyId(Optional.ofNullable(request.getCompanyId()).orElse(entity.getCompanyId()))
        .registrationCode(Optional.ofNullable(request.getRegistrationCode())
                              .orElse(entity.getRegistrationCode()))
        .name(Optional.ofNullable(request.getName())
                  .orElse(entity.getName()))
        .registrationType(Optional.ofNullable(request.getRegistrationType())
                              .orElse(entity.getRegistrationType()))
        .registrationNumber(Optional.ofNullable(request.getRegistrationNumber())
                                .orElse(entity.getRegistrationNumber()))
        .participantPeriodEffect(getParticipantPeriodoEffectList(entity, request))
        .build();
  }

  private Set<ParticipantPeriodEffect> getParticipantPeriodoEffectList(Participant entity,
                                                                       ParticipantRequest request) {
    return request.getParticipantPeriodEffect()
        .stream()
        .map(periodEffectRequest ->
                 ParticipantPeriodEffect.builder()
                     .isNew(false)
                     .companyId(Optional.ofNullable(request.getCompanyId())
                                    .orElse(entity.getCompanyId()))
                     .startDate(Optional.ofNullable(periodEffectRequest.getStartDate())
                                    .orElse(periodEffectRequest.getStartDate()))
                     .name(Optional.ofNullable(periodEffectRequest.getName())
                                    .orElse(periodEffectRequest.getName()))
                     .legalName(Optional.ofNullable(periodEffectRequest.getLegalName())
                                    .orElse(periodEffectRequest.getLegalName()))
                     .countingBasis(Optional.ofNullable(periodEffectRequest.getCountingBasis())
                                    .orElse(periodEffectRequest.getCountingBasis()))
                     .companySize(Optional.ofNullable(periodEffectRequest.getCompanySize())
                                    .orElse(periodEffectRequest.getCompanySize()))
                     .legalNature(Optional.ofNullable(periodEffectRequest.getLegalNature())
                                    .orElse(periodEffectRequest.getLegalNature()))
                     .mainCnae(Optional.ofNullable(periodEffectRequest.getMainCnae())
                                    .orElse(periodEffectRequest.getMainCnae()))
                     .stateInscription(Optional.ofNullable(periodEffectRequest.getStateInscription())
                                    .orElse(periodEffectRequest.getStateInscription()))
                     .municipalInscription(Optional.ofNullable(periodEffectRequest.getMunicipalInscription())
                                    .orElse(periodEffectRequest.getMunicipalInscription()))
                     .suframaInscription(Optional.ofNullable(periodEffectRequest.getSuframaInscription())
                                    .orElse(periodEffectRequest.getSuframaInscription()))
                     .build()
            )
        .collect(Collectors.toSet());
  }
}
