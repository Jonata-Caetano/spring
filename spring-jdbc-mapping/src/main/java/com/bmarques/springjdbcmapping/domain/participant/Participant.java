package com.bmarques.springjdbcmapping.domain.participant;

import com.bmarques.springjdbcmapping.domain.util.AuditableBaseEntity;
import java.time.LocalDateTime;
import java.util.Set;
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
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("participant")
public class Participant extends AuditableBaseEntity<UUID> implements Persistable<UUID> {

  @Transient
  private boolean isNew;

  @Id
  @Column("participant_id")
  private UUID id;

  @Column("company_id")
  private UUID companyId;

  @Column("registration_code")
  private Integer registrationCode;

  @Column("name")
  private String name;

  @Column("registration_type")
  private String registrationType;

  @Column("registration_number")
  private String registrationNumber;

  @MappedCollection(idColumn = "participant_id")
  private Set<ParticipantPeriodEffect> participantPeriodEffect;

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

  @Builder
  public Participant(LocalDateTime createDate, UUID createdByContactId, LocalDateTime changed,
                     UUID changedByContactId, boolean isNew, UUID id, UUID companyId,
                     Integer registrationCode, String name, String registrationType,
                     String registrationNumber,
                     Set<ParticipantPeriodEffect> participantPeriodEffect) {
    super(createDate, createdByContactId, changed, changedByContactId);
    this.isNew = isNew;
    this.id = id;
    this.companyId = companyId;
    this.registrationCode = registrationCode;
    this.name = name;
    this.registrationType = registrationType;
    this.registrationNumber = registrationNumber;
    this.participantPeriodEffect = participantPeriodEffect;
  }
}
