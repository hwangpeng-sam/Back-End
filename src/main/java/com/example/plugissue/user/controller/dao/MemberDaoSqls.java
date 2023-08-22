package com.example.plugissue.user.controller.dao;

public class MemberDaoSqls {
    public static final String SELECT_ALL_BY_EMAIL =
            "SELECT id, name, password, email, create_date, modify_date FROM member WHERE email = :email";
}
