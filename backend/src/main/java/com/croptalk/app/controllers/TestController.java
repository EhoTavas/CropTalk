package com.croptalk.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.croptalk.app.models.TestRequest;
import com.croptalk.app.services.Test;

@RestController
@RequestMapping("/teste")

public class TestController
{
    @Autowired
    private Test test;

    @PostMapping("/Test")

    public ResponseEntity<Integer> testarValor (@RequestBody TestRequest num)
    {
        try 
        {
            return ResponseEntity.ok(test.teste(num));
        }

        catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna 500 Internal Server Error
        }
    }

}