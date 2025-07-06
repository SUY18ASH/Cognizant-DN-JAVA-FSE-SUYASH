package com.library.repository;

import java.util.Arrays;
import java.util.List;
import com.library.model.Book;

public class BookRepository {
    public List<Book> findAll() {

        return Arrays.asList(
                new Book(1, "1984", "George Orwell"),
                new Book(2, "To Kill a Mockingbird", "Harper Lee")
        );
    }
}
