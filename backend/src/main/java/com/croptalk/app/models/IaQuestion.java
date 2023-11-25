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
    private String question;
    private String awnser;
    private String typeBusiness;

    public IaQuestion(){

    }

    //getters
    public String getQuestion(){
        return this.question;
    }

    public String getAwnser(){
        return this.awnser;
    }
    
    public String getTypeBusiness(){
        return this.typeBusiness;
    }

    //setters

    public void setQuestion(String question) throws Exception{
        if(question == null || question.trim().isEmpty()) throw new Exception("Insira a sua pergunta!");
        this.question = question;
    }

    public void setAwnser(String awnser){
        this.awnser = awnser;
    }

    public void setTypeBusiness(String typeBusiness) throws Exception{
        if(typeBusiness == null || typeBusiness.trim().isEmpty()) throw new Exception("Selecione o tipo do seu negócio!");
        this.typeBusiness = typeBusiness;
    }
}
