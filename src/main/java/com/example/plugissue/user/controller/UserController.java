package com.example.plugissue.user.controller;

import com.example.plugissue.user.entity.User;
import com.example.plugissue.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "Users Api")
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @ResponseBody
    @PostMapping("/user/join")
    public ResponseEntity<Long> join(@RequestBody User user){
        Long id = userService.saveUsers(user);
        return ResponseEntity.ok(id);
    }
}
