package com.group.libraryapp.domain;

import lombok.*;

import javax.persistence.*;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 25, name = "name")
    private String name;
    @Column(name="age")
    private Integer age;

    public User(Integer age, String name) {
        this.name = name;
        this.age = age;
    }
    public void updateName(String name){
        this.name = name;
    }
}
