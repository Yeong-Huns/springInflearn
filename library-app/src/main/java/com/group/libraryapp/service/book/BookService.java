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

    //스프링 컨테이너의 제어의 역전(IoC)를 사용해서 BookService의 코드 한 줄도 수정하지않고
    //Repository를 변경 하였다.
    public void saveBook(){
        repository.saveBook();
    }
}
