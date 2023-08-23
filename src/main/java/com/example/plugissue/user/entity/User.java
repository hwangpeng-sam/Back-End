package com.example.plugissue.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(length = 50)
    private String userId;

    @Column(length = 50)
    private String pw;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String phone;

    @Column(length = 50)
    private String email;


}
