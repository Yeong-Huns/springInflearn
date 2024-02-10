package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Primary
@Service
public class UserServiceV2 {
    private final UserRepository repository;

    public UserServiceV2(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveUser(UserCreateRequest request){
       User u=repository.save(new User(request.getAge(), request.getName()));
    }
    //아래 있는 함수가 시작될 때, start transaction 해준다
    //함수가 예외없이 잘 끝났다면 commit,
    //문제가 생겼다면 rollback
    @Transactional(readOnly = true) //저장,수정,업데이트 불가 = 약간의 성능적 이점
    public List<UserResponse> getUsers(){
        return repository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?
        User user = repository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
                //Optional<user>
        user.updateName(request.getName());
    } //트랜잭션 시작->영속성 컨텍스트 시작 User을 가져왔고, 변경함 (영속성 컨텍스트 변경감지, 자동저장) ->종료
    @Transactional
    public void deleteUser(String name){
        //SELECT * FROM user WHERE name=? 을 어떻게 만들수있을까?
        User user = repository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        repository.delete(user);
    }

}
