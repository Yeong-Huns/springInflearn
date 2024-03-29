package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanHistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanHistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.dto.book.request.BookTestRequest;
import com.group.libraryapp.dto.book.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final UserLoanHistoryRepository loanHistoryRepository;
    private final UserRepository userRepository;
    //스프링 컨테이너의 제어의 역전(IoC)를 사용해서 BookService의 코드 한 줄도 수정하지않고
    //Repository를 변경 하였다.
    @Transactional
    public void saveBook(BookCreateRequest request){
        repository.save(new Book(request.getName()));
    }
    @Transactional(readOnly = true)
    public List<BookResponse> getBooks(){
        return repository.findAll().stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateBook(){
    }
    @Transactional
    public void deleteBook(){

    }
    @Transactional
    public void loanBook(BookLoanRequest request){
        Book book = repository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        if(loanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false))
            throw new IllegalArgumentException("대출된 책입니다.");
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.loanBook(request.getBookName());
        //1. 책 정보를 확인한다.
        //2. 대출기록 정보를 가져온다. (대출중인지 확인)
        //3. 만약 확인해서 대출중이라면 오류코드 보낸다.
        //4. 유저정보를 가져온다.
        //5. 유저정보와 책 정보를 기반으로 UserLoanHistory 저장
    }
    @Transactional
    public void returnBook(BookReturnRequest request){
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
        //영속성 컨텍스트 : 변경사항 감지로 자동저장
    }
    @Transactional
    public void deleteTest(BookTestRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.removeOneHistory(request.getBookName());
    }
    @Transactional
    public void printList(long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.printLoanHistories();
    }
}
