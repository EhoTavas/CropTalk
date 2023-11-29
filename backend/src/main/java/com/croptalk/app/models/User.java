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

  private boolean nameIsValid(String name) {
    if (name.matches(".*\\d.*"))
      return false;
    return true;
  }

  private boolean emailIsValid(String email) {
    if (!email.matches("^[^@]+@[^@]+\\.(com|br)$"))
      return false;
    return true;
  }

  private boolean phoneIsValid(String phone) {
    // Remover caracteres especiais usando expressão regular
    phone = phone.replaceAll("[^0-9]", "");
    if (phone.length() != 11)
      return false;
    return true;
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

  public void setName(String name) throws Exception {
    if (name == null || name.trim().isEmpty())
      throw new Exception("Nome ausente");
    if (!nameIsValid(name))
      throw new Exception("Nome inválido!");
    this.name = name;
  }

  public void setEmail(String email) throws Exception {
    if (email == null)
      throw new Exception("E-mail ausente");
    if (!emailIsValid(email))
      throw new Exception("E-mail inválido");
    this.email = email;
  }

  public void setPhone(String phone) throws Exception {
    if (phone == null)
      throw new Exception("Telefone ausente!");
    if (!phoneIsValid(phone))
      throw new Exception("Telefone inválido!");
    this.phone = phone;
  }

  public void setPassword(String password) throws Exception {
    if (password == null)
      throw new Exception("Senha ausente");
    if (password.length() < 8)
      throw new Exception("A senha deve ter pelo menos 8 dígitos");
    this.password = hashPassword(password);
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
