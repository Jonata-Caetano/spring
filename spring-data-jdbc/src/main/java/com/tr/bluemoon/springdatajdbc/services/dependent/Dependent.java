
package com.tr.bluemoon.springdatajdbc.services.dependent;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("dependent")
public class Dependent {

    @Id
    private Integer id;
    private Integer client;
    private String name;

    public Dependent() {

    }

    public Dependent(Integer id, Integer client, String name) {
        this.id = id;
        this.client = client;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", client=" + client +
                '}';
    }
}