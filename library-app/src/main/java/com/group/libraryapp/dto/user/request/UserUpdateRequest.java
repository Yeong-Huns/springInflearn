package com.group.libraryapp.dto.user.request;

import lombok.Getter;


public class UserUpdateRequest {
    private long id;
    private String name;
    public long getId() {return id;}
    public String getName() {return name;}
}
