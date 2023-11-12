package com.croptalk.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.croptalk.app.models.IaQuestion;

public interface IaQuestionRepository extends MongoRepository<IaQuestion, String> {
}