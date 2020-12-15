package com.bmarques.springlombokvar;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Participant {

  private Integer code;
  private String name;
  private String cpf;
}
