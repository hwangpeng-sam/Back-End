package com.example.plugissue.user.controller.dto;

import com.example.plugissue.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;

    public UserDto(User user){
        this.id = user.getUserId();
        this.pw = user.getPw();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
