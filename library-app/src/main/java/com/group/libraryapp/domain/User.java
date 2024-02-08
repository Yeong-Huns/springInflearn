package com.group.libraryapp.domain;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public User(String name, Integer age) {
        if(name == null || name.isBlank()){ //name값이 null of 값 x : retyrn 500 Internal server error
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }
}