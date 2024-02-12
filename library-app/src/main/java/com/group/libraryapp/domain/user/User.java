package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanHistory.UserLoanHistory;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25, name = "name")
    private String name;
    @Column(name="age")
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //이 user가 삭제되면 연관된 userLoanHistory도 삭제(cascade)
    //객체간의 관계가 끊어진 데이터를 자동으로 제거하는 옵션 (orphanRemoval)
    private final List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public User(Integer age, String name) {
        this.name = name;
        this.age = age;
    }
    public void updateName(String name){
        this.name = name;
    }

    public void printLoanHistories(){
        System.out.println("===============================");
        for (UserLoanHistory userLoanHistory : userLoanHistories)
            System.out.print(userLoanHistory.getBookName() + " ");
        System.out.println("===============================");
        System.out.println("회원이름 : " + this.name);
    }
    public void removeOneHistory(String bookName){
        userLoanHistories.removeIf(history->bookName.equals(history.getBookName()));
    }
}
