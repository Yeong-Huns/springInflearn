package com.group.libraryapp.dto.user.request;

/*
POST/user
{
"name": "String", (Not null)
"age": int
}
return X (Void)
*/

public class UserCreateRequest {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
