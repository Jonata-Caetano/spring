package com.bmarques.springr2dbc.domain;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("client")
public class Client {

  @Id
  private Integer id;
  private String name;

  @MappedCollection(idColumn = "client_id")
  private Set<ClientDependent> clientDependent;
}
