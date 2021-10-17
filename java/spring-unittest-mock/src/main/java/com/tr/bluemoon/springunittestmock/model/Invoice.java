
package com.tr.bluemoon.springunittestmock.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    @Column(name = "client_name")
    private String client;
    private BigDecimal value;

    public Invoice() {
    }

    public Invoice(Integer id, LocalDate dateOfIssue, String client, BigDecimal value) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
        this.client = client;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", dateOfIssue=" + dateOfIssue +
                ", client='" + client + '\'' +
                ", value=" + value +
                '}';
    }
}