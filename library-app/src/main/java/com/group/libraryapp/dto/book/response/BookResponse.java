package com.group.libraryapp.dto.book.response;

import com.group.libraryapp.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponse {
    private final Long id;
    private final String name;
    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
    }
}
