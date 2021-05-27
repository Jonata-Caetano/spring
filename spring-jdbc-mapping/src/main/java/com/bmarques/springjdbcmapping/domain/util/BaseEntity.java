package com.bmarques.springjdbcmapping.domain.util;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Persistable;

public abstract class BaseEntity<T> implements Persistable<T>, Serializable {

  @Override
  public boolean isNew() {
    if (getId() instanceof String) {
      return Optional.ofNullable((String) getId()).orElse("").trim().length() == 0;
    }
    return getId() == null;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity<T> other = (BaseEntity<T>) o;
    return Objects.equals(getId(), other.getId());
  }
}
