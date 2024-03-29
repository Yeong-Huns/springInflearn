package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.dto.book.request.BookTestRequest;
import com.group.libraryapp.dto.book.response.BookResponse;
import com.group.libraryapp.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        service.saveBook(request);
    }
    @GetMapping("/book")
    public List<BookResponse> getBooks(){return service.getBooks();}

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        service.loanBook(request);
    }
    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request){
        service.returnBook(request);
    }

    @PutMapping("/book/test")
    public void deleteTest(@RequestBody BookTestRequest request){
        service.deleteTest(request);
    }
    @GetMapping("/book/list")
    public void printList(@RequestParam long userId){
        service.printList(userId);
    }
}
