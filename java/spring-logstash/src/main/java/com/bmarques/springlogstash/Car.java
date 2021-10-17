package com.bmarques.springlogstash;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {

  private Integer code;
  private String description;
  private String trunk;
}
