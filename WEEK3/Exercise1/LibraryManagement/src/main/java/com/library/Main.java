package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.model.Book;

public class Main {
    public static void main(String[] args) {
        // 1. Load the XML context from src/main/resources/applicationContext.xml
        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            // 2. Get your service bean
            BookService bookService = ctx.getBean("bookService", BookService.class);

            // 3. Call the service and print results
            for (Book b : bookService.listAllBooks()) {
                System.out.println(b);
            }
        }
    }
}
