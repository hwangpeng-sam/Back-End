package com.example.plugissue.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index() {
        return "index"; // => templates 폴더의 index.html을 찾아감
    }
}
