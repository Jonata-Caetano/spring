package com.tr.bluemoon.springdatajdbc.services.book;

import com.tr.bluemoon.springdatajdbc.services.author.Author;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<AuthorRef> authors = new HashSet<>();

    public void addAuthor(Author author) {
        this.authors.add(new AuthorRef(author.getId()));
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<AuthorRef> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorRef> authors) {
        this.authors = authors;
    }
}
