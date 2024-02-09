package com.group.libraryapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository JpaRepository를 상속받는것만으로 자동으로 Bean 등록
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    //아니 이렇게만 했는데 찾아준다고?
}
