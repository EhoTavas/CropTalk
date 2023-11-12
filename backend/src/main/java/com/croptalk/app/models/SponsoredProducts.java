package com.croptalk.app.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document
public class SponsoredProducts {
    @Id
    private String idProduct;
    private String nameProduct;
    private String urlProduct;

    public SponsoredProducts(String nameProduct, String urlProduct){
        this.nameProduct = nameProduct;
        this.urlProduct = urlProduct;
    }

    //getters
    public String getNameProduct(){
        return this.nameProduct;
    }

    public String getUrlProduct(){
        return this.urlProduct;
    }

    //setters
    public void setNameProduct(String nameProduct){
        this.nameProduct = nameProduct;
    }

    public void setUrlProduct(String urlProduct){
        this.urlProduct = urlProduct;
    }
    
}
