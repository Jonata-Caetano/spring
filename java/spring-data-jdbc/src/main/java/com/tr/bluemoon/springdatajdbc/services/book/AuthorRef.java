package com.tr.bluemoon.springdatajdbc.services.book;

import org.springframework.data.relational.core.mapping.Table;

@Table("book_author")
public class AuthorRef {
    private Long author;

    AuthorRef(Long author) {
        this.author = author;
    }
}
