package com.bmarques.springblockhound.domain.participant;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "participant")
public class Participant {

  @Id
  @Column("participant_id")
  private UUID id;
  private Integer code;
  private String name;

}
