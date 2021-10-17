package com.bmarques.springjdbcmapping.domain.participant;

import com.bmarques.springjdbcmapping.domain.util.AuditableBaseEntity;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("participant_period_effect")
public class ParticipantPeriodEffect extends AuditableBaseEntity<UUID> implements Persistable<UUID> {

  @Transient
  private boolean isNew;

  @Id
  @Column("participant_period_effect_id")
  private UUID id;

  @Column("company_id")
  private UUID companyId;

  @Column("participant_id")
  private UUID participantId;

  @Column("start_date")
  private LocalDate startDate;

  @Column("name")
  private String name;

  @Column("legal_name")
  private String legalName;

  @Column("counting_basis")
  private String countingBasis;

  @Column("company_size")
  private String companySize;

  @Column("legal_nature")
  private String legalNature;

  @Column("main_cnae")
  private String mainCnae;

  @Column("state_inscription")
  private String stateInscription;

  @Column("municipal_inscription")
  private String municipalInscription;

  @Column("suframa_inscription")
  private String suframaInscription;

  @Override
  public boolean isNew() {
    return isNew;
  }

  public void setNew(boolean isNew) {
    this.isNew = isNew;
  }

  @Override
  public UUID getId() {
    return id;
  }
}
