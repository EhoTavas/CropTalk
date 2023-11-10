package com.croptalk.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.croptalk.app.models.User;

public interface UserRepository extends MongoRepository<User, String> {
}
