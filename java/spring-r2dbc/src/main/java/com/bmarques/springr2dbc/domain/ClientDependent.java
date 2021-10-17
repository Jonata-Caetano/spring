package com.bmarques.springr2dbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("client_dependent")
public class ClientDependent {

  @Id
  private Integer id;
  private String name;
  @Column("client_id")
  private Integer ClientId;
}
