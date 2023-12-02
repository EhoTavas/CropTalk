package com.croptalk.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croptalk.app.Cliente.Cliente;
import com.croptalk.app.models.TestRequest;

@Service
public class Test {
    @Autowired
    private Cliente cliente;


    public int teste (TestRequest num)
    {
        int numTeste = cliente.retornoNumeroPergunta(num.getValor());


        return numTeste;
    }


}
