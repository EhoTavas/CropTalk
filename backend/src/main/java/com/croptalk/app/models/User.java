package com.croptalk.app.models;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User implements UserDetails {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
  private boolean isActive;
  private UserRole role;

  public User(String name, String email, String phone, String password, boolean isActive, UserRole role) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.password = hashPassword(password);
    this.isActive = isActive;
    this.role = role;
  }

  public String hashPassword(String password) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder.encode(password);
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }

  public boolean getActive() {
    return this.isActive;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.role == UserRole.ADMIN)
      return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
    else
      return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
