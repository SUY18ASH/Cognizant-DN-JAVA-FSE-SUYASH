package com.library.model;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id     = id;
        this.title  = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author;
    }
}
