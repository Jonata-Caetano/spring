package com.tr.bluemoon.springunittestmock.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Tax {
    @Id
    private Integer id;
    private LocalDate period;
    private BigDecimal value;

    public Tax() {
    }

    public Tax(Integer id, LocalDate period, BigDecimal value) {
        this.id = id;
        this.period = period;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "id=" + id +
                ", period=" + period +
                ", value=" + value +
                '}';
    }
}
