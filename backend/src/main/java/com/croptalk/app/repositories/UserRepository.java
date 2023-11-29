package com.croptalk.app.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.croptalk.app.models.User;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<UserDetails> findByEmail(String email);
}
