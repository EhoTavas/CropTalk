package com.croptalk.app.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document

public class IaQuestion {
    @Id
    private String idQuestion;
    private String idUser; 
    private String idSponsoredProduts; 
    private String question;
    private String awnser;
    private Byte typeSolution;

    public IaQuestion(String idUser, String idSponsoredProduts, String question, String awnser, Byte typeSolution){
        this.idUser = idUser;
        this.idSponsoredProduts = idSponsoredProduts;
        this.question = question;
        this.awnser = awnser;
        this.typeSolution = typeSolution;
    }

    //getters
    public String getIdUser(){
        return this.idUser;
    }

    public String getIdSponsoredPoduts(){
        return this.idSponsoredProduts;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAwnser(){
        return this.awnser;
    }
    
    public Byte getTypeSolution(){
        return this.typeSolution;
    }

    //setters
    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public void setIdSponsosedProduts(String idSponsoredProduts){
        this.idSponsoredProduts = idSponsoredProduts;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAwnser(String awnser){
        this.awnser = awnser;
    }

    public void setTypeSolution(Byte typeSoluction){
        this.typeSolution = typeSoluction;
    }
}
