package com.croptalk.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.croptalk.app.models.ComunityPost;

public interface ComunityPostRepository extends MongoRepository<ComunityPost, String> {
}
