package com.example.plugissue.user.controller;

import com.example.plugissue.user.UserDao;
import com.example.plugissue.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @GetMapping("/user/get-all") // 회원가입
    public List<User> getAllUsers() {
        return userDao.getAllUsers();

    }

    // android에서 새로운 정보를 받을 때
    @PostMapping("/user/repository") //
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }
}
