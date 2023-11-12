package com.croptalk.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.croptalk.app.models.SponsoredProducts;

public interface SponsoredProductsRepository extends MongoRepository<SponsoredProducts, String> {
}
