package com.croptalk.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document
public class ComunityPost {
  @Id
  private String id;
  private String post;
  private String typeSolution;

  public ComunityPost(){

  }

  //getters
  public String getPost(){
    return this.post;
  }

  public String getTypeSolution(){
    return this.typeSolution;
  }

  //setters
  public void setPost(String post){
    this.post = post;
  }

  public void setTypeSolution(String typeSolution){
    this.typeSolution = typeSolution;
  }
}