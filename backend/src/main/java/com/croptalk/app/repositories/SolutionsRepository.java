package com.croptalk.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.croptalk.app.models.Solutions;

public interface SolutionsRepository extends MongoRepository<Solutions, String> {
}

