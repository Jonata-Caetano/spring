package com.bmarques.springjdbcmapping.domain.util;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditableBaseEntity<T> extends BaseEntity<T> {

  @CreatedDate
  @Column("create_date")
  private LocalDateTime createDate;

  @Column("created_by__contact_id")
  private UUID createdByContactId;

  @LastModifiedDate
  @Column("changed")
  private LocalDateTime changed;

  @Column("changed_by__contact_id")
  private UUID changedByContactId;
}
