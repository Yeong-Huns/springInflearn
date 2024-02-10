package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserServiceV1 {

    private final UserJdbcRepository repository;

    public UserServiceV1(UserJdbcRepository repository) {
        this.repository = repository;
    }

    public void saveUser(UserCreateRequest request) {
        repository.saveUser(request);
    }

    public List<UserResponse> getUsers() {
        return repository.getUsers();
    }

    public void updateUser(UserUpdateRequest request) {
        if (repository.isUserNotExist(request.getId())) throw new IllegalArgumentException();
        //필드가 존재하지않는다면 Empty / 있으면 0이 반환된다.
        repository.updateUser(request);
    }

    public void deleteUser(String name) {
        if (repository.isUserNotExist(name)) throw new IllegalArgumentException();
        //필드가 존재하지않는다면 Empty / 있으면 0이 반환된다.
        repository.deleteUser(name);
    }
}
