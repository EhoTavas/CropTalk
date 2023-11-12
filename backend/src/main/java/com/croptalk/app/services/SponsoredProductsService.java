package com.croptalk.app.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.croptalk.app.models.SponsoredProducts;
import com.croptalk.app.repositories.SponsoredProductsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SponsoredProductsService {
  private final SponsoredProductsRepository sponsoredProductsRepository;

  public List<SponsoredProducts> getAllSponsoredProducts() {
    return sponsoredProductsRepository.findAll();
  }

  public Optional<SponsoredProducts> getProductById(String idProduct) {
    return sponsoredProductsRepository.findById(idProduct);
  }

  public SponsoredProducts createProduct(SponsoredProducts question) {
    return sponsoredProductsRepository.insert(question);
  }

  public void deleteProduct(String idProduct){
     sponsoredProductsRepository.deleteById(idProduct);
  }
}
