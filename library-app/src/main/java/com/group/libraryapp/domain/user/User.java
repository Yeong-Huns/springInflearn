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

    @OneToMany(mappedBy = "user")
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public User(Integer age, String name) {
        this.name = name;
        this.age = age;
    }
    public void updateName(String name){
        this.name = name;
    }

}
