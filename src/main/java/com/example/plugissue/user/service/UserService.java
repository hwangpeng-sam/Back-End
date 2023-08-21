package com.example.plugissue.user.service;

import com.example.plugissue.user.domain.User;
import com.example.plugissue.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // 회원가입
    public String join(User user){
        // 같은 이름이 있는 중복 회원 X
        validateOverapUser(user);
        userRepository.save(user);
        return user.getId();
    }
    // 중복된 회원이 있는지 검증해주는 함수
    public void validateOverapUser(User user){
        // Optional 객체 이므로 ifPresent 함수를 이용해서 null 조건문 없이 작성 할 수 있습니다
        userRepository.findByName(user.getName()).ifPresent(m -> {
            throw new IllegalStateException("already Exists");
        });
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne (Long id){
        return userRepository.findById(id);
    }



}
