package com.example.plugissue.user.repository;

import com.example.plugissue.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;


public interface UserRepository extends JpaRepository<User,Long> {



}
