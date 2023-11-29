package com.croptalk.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.croptalk.app.models.User;
import com.croptalk.app.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(String userId) {
    return userRepository.findById(userId);
  }

  public Optional<UserDetails> getUserByEmail(String userEmail) {
    return userRepository.findByEmail(userEmail);
  }

  public User createUser(User user) {
    return userRepository.insert(user);
  }

  public void deleteUser(String userId) {
    userRepository.deleteById(userId);
  }
}
