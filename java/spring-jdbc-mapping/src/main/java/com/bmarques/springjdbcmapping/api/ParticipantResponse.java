package com.bmarques.springjdbcmapping.api;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantResponse {

  private UUID id;
  private UUID companyId;
  private Integer registrationCode;
  private String name;
  private String registrationType;
  private String registrationNumber;

}
