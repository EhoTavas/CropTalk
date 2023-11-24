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
  private String typeSolutions;
  private String solution;
  private String applicationSolution;

  public Solutions(String typeSolutions, String solution, String applicationSolution) {
    this.typeSolutions = typeSolutions;
    this.solution = solution;
    this.applicationSolution = applicationSolution;
  }

  public Solutions() {
  }

  // getters
  public String getTypeSolution() {
    return this.typeSolutions;
  }

  public String getSolution() {
    return this.solution;
  }

  public String getApplicationSolution() {
    return this.applicationSolution;
  }

  // setters
  public void setTypeSolutions(String typeSolutions) {
    this.typeSolutions = typeSolutions;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

  public void setApplicationSolution(String applicationSolution) {
    this.applicationSolution = applicationSolution;
  }

}

