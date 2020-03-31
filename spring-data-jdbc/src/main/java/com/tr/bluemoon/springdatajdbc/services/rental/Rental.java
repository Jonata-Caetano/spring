package com.tr.bluemoon.springdatajdbc.services.rental;

import org.springframework.data.annotation.Id;

import java.time.Duration;

public class Rental {
    @Id
    private Long id;
    private Duration duration;
    private Integer price;

    public Rental(Long id, Duration duration, Integer price) {
        this.id = id;
        this.duration = duration;
        this.price = price;
    }
}
