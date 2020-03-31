package com.tr.bluemoon.springdatajdbc.services.truck;

import com.tr.bluemoon.springdatajdbc.services.engine.Engine;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Truck {
    @Id
    private Long id;
    private String name;

    private Engine engine;

    public Truck(Long id, String name, Engine engine) {
        this.id = id;
        this.name = name;
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
