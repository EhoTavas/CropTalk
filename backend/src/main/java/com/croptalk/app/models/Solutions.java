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
  
  //construtor
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
  public void setTypeSolutions(String typeSolutions) throws Exception{
    if(typeSolutions == null || typeSolutions.trim().isEmpty())throw new Exception("Insira o tipo da solução!");
    this.typeSolutions = typeSolutions;
  }

  public void setSolution(String solution) throws Exception {
    if(solution == null || solution.trim().isEmpty()) throw new Exception("Insira a solução!");
    this.solution = solution;
  }

  public void setApplicationSolution(String applicationSolution) throws Exception {
    if(applicationSolution == null || applicationSolution.trim().isEmpty()) throw new Exception("Insira o modo de aplicação!");
    this.applicationSolution = applicationSolution;
  }

}

