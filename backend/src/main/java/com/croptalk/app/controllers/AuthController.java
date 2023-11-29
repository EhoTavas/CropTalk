package com.croptalk.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.croptalk.app.dao.LoginRequest;
import com.croptalk.app.dao.SignupRequest;
import com.croptalk.app.models.User;
import com.croptalk.app.services.UserService;

import lombok.AllArgsConstructor;
import lombok.var;

@RestController
@RequestMapping(path = "api/v1/auth")
@AllArgsConstructor
public class AuthController {
  private final UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/signin")
  public ResponseEntity login(@RequestBody LoginRequest data) {
    try {
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
      var auth = this.authenticationManager.authenticate(usernamePassword);
      return ResponseEntity.ok().build();
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
    }

  }

  @PostMapping("/signup")
  public ResponseEntity<User> signup(@RequestBody SignupRequest data) {
    // Check if the request body is null and if the user already exists
    if (data == null || userService.getUserByEmail(data.getEmail()) != null) {
      return ResponseEntity.badRequest().build();
    }

    // Proceed with user creation logic
    User newUser = new User(data.getName(), data.getEmail(), data.getPhone(), data.getPassword(), data.isActive(),
        data.getRole());
    User createdUser = userService.createUser(newUser);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }
}
