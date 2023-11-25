package com.croptalk.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Routes {

    @GetMapping("/")
    public String index() {
        return "../frontend/views/index.html";
    }

    @GetMapping("/register")
    public String register() {
        return "../frontend/views/register.html";
    }

    @GetMapping("/login")
    public String login() {
        return "../frontend/views/login.html";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "../frontend/views/quiz.html";
    }

    @GetMapping("/comunity")
    public String comunity() {
        return "../frontend/views/comunity.html";
    }

    @GetMapping("/solutions")
    public String solutions() {
        return "../frontend/views/solutions.html";
    }

    @GetMapping("/404")
    public String page404() {
        return "../frontend/views/404.html";
    }
}
