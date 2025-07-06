package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.model.Book;

public class Main {
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            BookService bookService = ctx.getBean("bookService", BookService.class);

            for (Book b : bookService.listAllBooks()) {
                System.out.println(b);
            }

            ctx.close();
        }
    }
}
