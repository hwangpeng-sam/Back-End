package com.example.plugissue.user.service;

import com.example.plugissue.user.controller.dto.UserDto;
import com.example.plugissue.user.entity.User;
import com.example.plugissue.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public Long saveUsers(User users){
        Long id = userRepository.save(users).getId();
        return id;
    }
}
