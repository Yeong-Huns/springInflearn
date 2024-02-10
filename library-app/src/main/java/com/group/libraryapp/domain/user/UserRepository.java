package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository //JpaRepository를 상속받는것만으로 자동으로 Bean 등록
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    //이렇게만 했는데 구현된다고?????
}
