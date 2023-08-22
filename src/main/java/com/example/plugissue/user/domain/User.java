package com.example.plugissue.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long userid;

    @Column(nullable = false, length = 30, unique = true)
    private String email;
    private String password;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, unique = true, length = 20)
    private String nickname;
    private int age;

    @OneToMany(mappedBy = "user")
    private List<User> roles = new ArrayList<>();
    public User(String email, String password, String username, String nickname) {
        this.email = email;
        this.password = password;
        this.name = username;
        this.nickname = nickname;
    }

}
