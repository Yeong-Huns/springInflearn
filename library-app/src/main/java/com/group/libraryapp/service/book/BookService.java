package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookMysqlRepository;
import com.group.libraryapp.repository.book.BookRepository;

public class BookService {

    private final BookRepository repository
            = new BookMemoryRepository();
           //= new BookMysqlRepository(); 이 부분만 변경하면 된다.
    public void saveBook(){
        repository.saveBook();
    }
}
