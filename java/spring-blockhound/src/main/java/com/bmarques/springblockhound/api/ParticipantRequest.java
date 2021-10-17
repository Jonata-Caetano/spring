package com.bmarques.springblockhound.api;

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
public class ParticipantRequest {

  private UUID id;
  private Integer code;
  private String name;
}
