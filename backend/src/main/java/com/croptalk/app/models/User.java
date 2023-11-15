package com.croptalk.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
  private String confirmPassword;
  private boolean isActive;

  public User(String name, String email, String phone, String password, String confirmPassword, boolean isActive) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.isActive = isActive;
  }

  public User() {
  }

  // getters
  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getPassword() {
    return this.password;
  }

  public String getConfirmPassword() {
    return this.confirmPassword;
  }

  public boolean getActive() {
    return this.isActive;
  }

  // setters
  public void setName(String name) {
    // nao precisa fazer validaçao, dados foram validados no frontend
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}
