package com.bmarques.springjdbcmapping.api;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantPeriodEffectRequest {

  private LocalDate startDate;
  private String name;
  private String legalName;
  private String countingBasis;
  private String companySize;
  private String legalNature;
  private String mainCnae;
  private String stateInscription;
  private String municipalInscription;
  private String suframaInscription;
}
