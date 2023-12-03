package com.croptalk.app.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TestRequest {

    private int num;

    public int getNum(){
        return num;
    }
}