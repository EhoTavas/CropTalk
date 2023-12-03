package com.croptalk.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croptalk.app.Cliente.Cliente;
import com.croptalk.app.models.ReduceNumberResponse;


@Service
public class ReduceNumberService {
    @Autowired
    private Cliente cliente;


    public int reduce (ReduceNumberResponse num)
    {
        int numReduce = cliente.retornoNumeroPergunta(num.getNum());


        return numReduce;
    }


}
