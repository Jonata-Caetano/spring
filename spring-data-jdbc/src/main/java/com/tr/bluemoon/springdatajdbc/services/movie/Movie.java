package com.tr.bluemoon.springdatajdbc.services.movie;

import com.tr.bluemoon.springdatajdbc.services.rental.Rental;
import org.springframework.data.annotation.Id;

public class Movie {
    @Id
    private Long id;
    private String title;
    private String description;
    private Rental rental;

    public Movie(Long id, String title, String description, Rental rental) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rental=" + rental +
                '}';
    }
}
