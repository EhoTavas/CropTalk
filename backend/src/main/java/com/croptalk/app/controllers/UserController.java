package com.croptalk.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.croptalk.app.models.User;
import com.croptalk.app.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5500") //endereço do frontend
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();

    // Check if there are users
    if (!users.isEmpty()) {
      // If users found, return them with a 200 OK status
      return ResponseEntity.ok(users);
    } else {
      // If no users found, return a 404 Not Found status
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable String userId) {
    Optional<User> userOptional = userService.getUserById(userId);
    User user = userOptional.orElse(null);

    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User newUserData) {
    // Check if the request body is null
    if (newUserData == null) {
      return ResponseEntity.badRequest().build(); // 400 Bad Request
    }

    // Proceed with user creation logic
    User createdUser = userService.createUser(newUserData);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }
}
