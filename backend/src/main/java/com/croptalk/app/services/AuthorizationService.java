package com.croptalk.app.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.croptalk.app.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserDetails> userOptional = userRepository.findByEmail(username);
    UserDetails user = userOptional.orElse(null);

    return user;
  }

}
