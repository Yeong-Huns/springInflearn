package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    /*
    @Autowired //@Autowired로 필드 직접주입
    private UserService service;
    @Autowired
    public void setService(UserService service) {
        //@Autowired와 setter를 사용
        this.service = service;
    }
    */
    private final UserService service;
    //생성자에 넣어두면 스프링이 알아서 넣어줌
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        service.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return service.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        service.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        service.deleteUser(name);
    }
}
