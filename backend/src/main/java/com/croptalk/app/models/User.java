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
  private String firstName;
  private String lastName;
  private String email;
  private boolean isActive;

  public User(String firstName, String lastName, String email, boolean isActive) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.isActive = isActive;
  }

  public User() {
  };

}
