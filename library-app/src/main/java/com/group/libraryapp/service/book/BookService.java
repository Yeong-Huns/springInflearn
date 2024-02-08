package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookMysqlRepository;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    //= new BookMysqlRepository(); 이 부분만 변경하면 된다.
    //BookService의 변경범위를 줄이긴했지만 그래도 아쉽다...
    //단 한줄의 코드도 변경하지않고 Repository를 변경할순 없을까?
    public void saveBook(){
        repository.saveBook();
    }
}
