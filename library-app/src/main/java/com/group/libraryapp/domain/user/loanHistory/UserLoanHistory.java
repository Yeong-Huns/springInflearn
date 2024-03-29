package com.group.libraryapp.domain.user.loanHistory;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_loan_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name= "book_name")
    private String bookName;

    @Column(name= "is_return")
    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }
    public void doReturn(){
        this.isReturn = true;
    }
}
