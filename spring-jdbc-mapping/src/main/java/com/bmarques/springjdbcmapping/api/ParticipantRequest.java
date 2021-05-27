package com.bmarques.springjdbcmapping.api;

import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParticipantRequest {

  private UUID companyId;
  private Integer registrationCode;
  private String name;
  private String registrationType;
  private String registrationNumber;
  private Set<ParticipantPeriodEffectRequest> participantPeriodEffect;
}
