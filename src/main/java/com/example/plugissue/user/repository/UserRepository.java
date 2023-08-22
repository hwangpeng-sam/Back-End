package com.example.plugissue.user.repository;

import com.example.plugissue.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //Optional은 조회 결과가 null인 경우를 대비해줌
    Optional<User> findByNickname(String nickname);
    
}

//public interface UserRepository extends CrudRepository<User, String> {
//    // 인터페이스란 기능에 대한 명세 집합
//    // 공통적인 함수들을 정의하고 실질적인 repository에 상속 받는다
//
//    // 멤버를 받으면 저장
//    User save(User user);
//
//    // id / name 으로 받고 User를 반환
//    Optional<User> findById(Long id);
//
//    Optional<User> findByName(String name);
//
//    //여러 멤버들을 리스트에 담아서 묶음으로 반환
//    List<User> findAll();
//
//}
