package com.bmarques.springlombokvar;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParticipantResponse {

  private Long id;
  private String fullName;
  private String registry;
}
