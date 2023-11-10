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
  @Id
  private String idUser;
  private String post;
  private byte typeSolution;

  public ComunityPost(String post, Byte typeSolution){
    this.post = post;
    this.typeSolution = typeSolution;

  }

  //getters
  public String getPost(){
    return this.post;
  }

  public Byte getTypeSolution(){
    return this.typeSolution;
  }

  //setters
  public void setPost(String post){
    this.post = post;
  }

  public void setTypeSolution(Byte typeSolution){
    this.typeSolution = typeSolution;
  }
}