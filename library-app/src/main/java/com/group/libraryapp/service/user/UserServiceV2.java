package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Primary
@Service
public class UserServiceV2 {
    private final UserRepository repository;

    public UserServiceV2(UserRepository repository) {
        this.repository = repository;
    }


    public void saveUser(UserCreateRequest request){
       User u=repository.save(new User(request.getAge(), request.getName()));
    }

    public List<UserResponse> getUsers(){

        return repository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?
        User user = repository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
                //Optional<user>
        user.updateName(request.getName());
        repository.save(user);
    }
    public void deleteUser(String name){
        //SELECT * FROM user WHERE name=? 을 어떻게 만들수있을까?
        User user = repository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        repository.delete(user);
    }

}
