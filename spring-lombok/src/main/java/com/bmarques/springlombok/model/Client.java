package com.bmarques.springlombok.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Client {

  private Integer code;
  private String name;
  private String phoneNumber;
  private String adress;
}
