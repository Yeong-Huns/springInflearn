package com.group.libraryapp.controller.book;

import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/book")
    public void saveBook(){
        service.saveBook();
    }
}
