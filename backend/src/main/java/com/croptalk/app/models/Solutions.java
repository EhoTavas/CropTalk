package com.croptalk.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document
public class Solutions {
  @Id
  private String id;
  private String userId;
  private Byte typeSolutions;
  private String solution;
  private String applicationSolution;

  public Solutions(String userId, Byte typeSolutions, String solution, String applicationSolution) {
    this.userId = userId;
    this.typeSolutions = typeSolutions;
    this.solution = solution;
    this.applicationSolution = applicationSolution;
  }

  // getters
  public String getuserId() {
    return this.userId;
  }

  public Byte getTypeSolution() {
    return this.typeSolutions;
  }

  public String getSolution() {
    return this.solution;
  }

  public String getApplicationSolution() {
    return this.applicationSolution;
  }

  // setters
  public void setIdUser(String userId) {
    // nao precisa fazer validaçao, dados foram validados no frontend
    this.userId = userId;
  }

  public void setTypeSolutions(Byte typeSolutions) {
    this.typeSolutions = typeSolutions;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

  public void setApplicationSolution(String applicationSolution) {
    this.applicationSolution = applicationSolution;
  }

}

