package com.croptalk.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz";
    }

    @GetMapping("/community")
    public String community() {
        return "community";
    }

    @GetMapping("/communityPost")
    public String communityPost() {
        return "communityPost";
    }

    @GetMapping("/communityTesteDinamico")
    public String communityTesteDinamico() {
        return "communityTesteDinamico";
    }

    @GetMapping("/postDetails")
    public String postDetails() {
        return "postDetails";
    }

    @GetMapping("/solutions")
    public String solutions() {
        return "solutions";
    }

    @GetMapping("/chatgpt")
    public String chatgpt() {
        return "chatgpt";
    }

    @GetMapping("/404")
    public String page404() {
        return "404";
    }
}
